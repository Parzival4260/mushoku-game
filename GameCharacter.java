package character;

import java.io.Serializable;
import java.util.*;

public class GameCharacter implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private String name;
    private Stats stats;
    private Element element;

    private CharacterClass characterClass; // ← FALTABA

    private List<Skill> learnedSkills;
    private List<Skill> equippedSkills;
    private List<StatusEffect> statusEffects;
    private List<StatModifier> activeBuffs;

    private int specialEnergy;
    private int maxSpecialEnergy = 100;

    private static final int MAX_MAGIC = 4;
    private static final int MAX_PHYSICAL = 4;
    private static final int MAX_SPECIAL = 2;

    private int manaFatigue;
    private int physicalFatigue;

    private Posture posture;

    private Map<Element, Double> affinities;
    private Map<Element, Double> resistances;

    private boolean defending = false;

    public GameCharacter(String name, Stats stats, Element element) {
        this.name = name;
        this.stats = stats;
        this.element = element;

        this.learnedSkills = new ArrayList<>();
        this.equippedSkills = new ArrayList<>();
        this.statusEffects = new ArrayList<>();
        this.activeBuffs = new ArrayList<>();

        this.affinities = new HashMap<>();
        this.resistances = new HashMap<>();

        this.manaFatigue = 0;
        this.physicalFatigue = 0;
        this.posture = Posture.BALANCED;
        this.specialEnergy = 0;
        this.characterClass = null; // ← FALTABA
    }

    // =========================
    // CHARACTER CLASS
    // =========================

    public void setCharacterClass(CharacterClass characterClass) {
        this.characterClass = characterClass;
    }

    public CharacterClass getCharacterClass() {
        return characterClass;
    }

    // =========================
    // SKILLS
    // =========================

    public void learnSkill(Skill skill) {

        for (Skill s : learnedSkills) {
            if (s.getId().equals(skill.getId())) {
                System.out.println("Ya conoce esta habilidad.");
                return;
            }
        }

        learnedSkills.add(skill);
        System.out.println(name + " aprendió " + skill.getName());
    }

    public boolean equipSkill(Skill skill) {

        if (!learnedSkills.contains(skill)) {
            return false;
        }

        int magicCount = 0;
        int physicalCount = 0;
        int specialCount = 0;

        for (Skill s : equippedSkills) {

            if (s.isSpecial()) {
                specialCount++;
            } else if (s.isMagical()) {
                magicCount++;
            } else {
                physicalCount++;
            }
        }

        if (skill.isSpecial() && specialCount >= MAX_SPECIAL) {
            return false;
        }

        if (!skill.isSpecial()) {

            if (skill.isMagical() && magicCount >= MAX_MAGIC) {
                return false;
            }

            if (!skill.isMagical() && physicalCount >= MAX_PHYSICAL) {
                return false;
            }
        }

        equippedSkills.add(skill);
        return true;
    }

    public List<Skill> getEquippedSkills() {
        return equippedSkills;
    }

    public List<Skill> getLearnedSkills() {
        return learnedSkills;
    }

    // =========================
    // BUFFS
    // =========================

    public void addBuff(StatModifier buff) {
        activeBuffs.add(buff);
    }

    public void processBuffs() {

        Iterator<StatModifier> iterator = activeBuffs.iterator();

        while (iterator.hasNext()) {

            StatModifier buff = iterator.next();
            buff.decreaseTurn();

            if (buff.isExpired()) {
                iterator.remove();
            }
        }
    }

    public void clearBuffs() {
        activeBuffs.clear();
    }

    public int getEffectiveStat(StatType type) {

        int baseValue;

        switch (type) {
            case ATTACK:
                baseValue = stats.getAttack();
                break;
            case DEFENSE:
                baseValue = stats.getDefense();
                break;
            case SPEED:
                baseValue = stats.getSpeed();
                break;
            case MAGIC_ATTACK:
                baseValue = stats.getMagicAttack();
                break;
            case MAGIC_DEFENSE:
                baseValue = stats.getMagicDefense();
                break;
            default:
                return 0;
        }

        int flatTotal = 0;
        double percentTotal = 0;

        for (StatModifier buff : activeBuffs) {
            if (buff.getType() == type) {
                flatTotal += buff.getFlatBonus();
                percentTotal += buff.getPercentBonus();
            }
        }

        int modified = baseValue + flatTotal;
        modified += (int) (modified * percentTotal);

        // ← AHORA YA EXISTE modified y characterClass
        if (characterClass != null) {
            switch (type) {
                case ATTACK:
                    modified = (int) (modified * characterClass.getAttackMultiplier());
                    break;
                case DEFENSE:
                    modified = (int) (modified * characterClass.getDefenseMultiplier());
                    break;
                case SPEED:
                    modified = (int) (modified * characterClass.getSpeedMultiplier());
                    break;
            }
        }

        return modified;
    }

    // =========================
    // ENERGÍA ESPECIAL
    // =========================

    public int getSpecialEnergy() {
        return specialEnergy;
    }

    public void addSpecialEnergy(int amount) {
        specialEnergy = Math.min(maxSpecialEnergy, specialEnergy + amount);
    }

    public void consumeSpecialEnergy(int amount) {
        specialEnergy = Math.max(0, specialEnergy - amount);
    }

    public void resetSpecialEnergy() {
        specialEnergy = 0;
    }

    // =========================
    // DEFENDER
    // =========================

    public void setDefending(boolean value) {
        defending = value;
    }

    public boolean isDefending() {
        return defending;
    }

    // =========================
    // OTROS
    // =========================

    public String getName() { return name; }
    public Stats getStats() { return stats; }
    public Element getElement() { return element; }

    public void setToukiLevel(int level) {
        stats.setToukiLevel(level);
    }

    public int getToukiLevel() {
        return stats.getToukiLevel();
    }

    public boolean isUnableToMove() {
        return false;
    }

    public void processStatusEffects() { }

    public void recoverAfterBattle() {
        stats.heal(stats.getMaxHP());
    }

    // =========================
    // ENUM
    // =========================

    public enum CharacterClass {

        MAGE(1.3, 1.1, 0.9),
        WARRIOR(1.2, 1.2, 1.0),
        FIGHTER(1.25, 1.0, 1.2),
        DEMON(1.4, 1.1, 1.1),
        DRAGON_KNIGHT(1.35, 1.3, 1.0),
        SAINT_ASSASSIN(1.5, 1.0, 1.4),
        PALADIN(1.2, 1.5, 0.9);

        private double attackMultiplier;
        private double defenseMultiplier;
        private double speedMultiplier;

        CharacterClass(double atk, double def, double spd) {
            this.attackMultiplier = atk;
            this.defenseMultiplier = def;
            this.speedMultiplier = spd;
        }

        public double getAttackMultiplier() { return attackMultiplier; }
        public double getDefenseMultiplier() { return defenseMultiplier; }
        public double getSpeedMultiplier() { return speedMultiplier; }
    }
}