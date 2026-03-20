package character;

import java.io.Serializable;
import java.util.EnumMap;
import java.util.Map;

public class Stats implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private static final int MAX_LEVEL = 200;

    private int level;
    private long experience;
    private long expToNextLevel;

    private int maxHP;
    private int currentHP;
    private int maxMP;
    private int currentMP;
    private int attack;
    private int magicAttack;
    private int defense;
    private int magicDefense;
    private int speed;
    private boolean cheatMode = false;

    // Nuevo sistema
    private int toukiLevel; // 0 - 10
    private Map<Element, Double> resistances;
    private Map<Element, Double> affinities;

    public Stats(int maxHP, int maxMP,
            int attack, int magicAttack,
            int defense, int magicDefense,
            int speed) {

        this.level = 1;
        this.experience = 0;
        this.expToNextLevel = 100;

        this.maxHP = maxHP;
        this.currentHP = maxHP;
        this.maxMP = maxMP;
        this.currentMP = maxMP;

        this.attack = attack;
        this.magicAttack = magicAttack;

        this.defense = defense;
        this.magicDefense = magicDefense;

        this.speed = speed;

        this.toukiLevel = 0;

        resistances = new EnumMap<>(Element.class);
        affinities = new EnumMap<>(Element.class);

        for (Element e : Element.values()) {
            resistances.put(e, 1.0);
            affinities.put(e, 1.0);
        }
    }

    // =========================
    // NIVEL
    // =========================
    public int getLevel() {
        return level;
    }

    public void addExperience(long amount) {

        if (level >= MAX_LEVEL) {
            return;
        }

        experience += amount;

        while (experience >= expToNextLevel && level < MAX_LEVEL) {
            experience -= expToNextLevel;
            levelUp(false);
        }
    }

    public void setLevelSilently(int targetLevel) {

        if (targetLevel > MAX_LEVEL) {
            targetLevel = MAX_LEVEL;
        }

        while (level < targetLevel) {
            levelUp(true);
        }
    }

    private void levelUp(boolean silent) {

        level++;
        expToNextLevel *= 1.5;

        attack += 5;
        magicAttack += 5;

        defense += 5;
        magicDefense += 5;

        speed += 2;
        currentHP = maxHP;
        currentMP = maxMP;

        if (!silent) {
            System.out.println("⬆ ¡Subiste a nivel " + level + "!");
        }
    }

    // =========================
    // TOUKI
    // =========================
    public int getToukiLevel() {
        return toukiLevel;
    }

    public void setToukiLevel(int level) {
        if (level < 0) {
            level = 0;
        }
        if (level > 10) {
            level = 10;
        }
        this.toukiLevel = level;
    }

    public double getPhysicalReductionFromTouki() {
        return 1 - (toukiLevel * 0.03);
    }

    public double getPhysicalBoostFromTouki() {
        return 1 + (toukiLevel * 0.02);
    }

    // =========================
    // RESISTENCIAS / AFINIDADES
    // =========================
    public double getResistance(Element e) {
        return resistances.getOrDefault(e, 1.0);
    }

    public void setResistance(Element e, double value) {
        resistances.put(e, value);
    }

    public double getAffinity(Element e) {
        return affinities.getOrDefault(e, 1.0);
    }

    public void setAffinity(Element e, double value) {
        affinities.put(e, value);
    }

    // =========================
    // COMBATE
    // =========================
    public int getMaxHP() {
        return maxHP;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public int getCurrentMP() {
        return currentMP;
    }

    public int getMaxMP() {
        return maxMP;
    }

    public int getSpeed() {
        return speed;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public boolean isAlive() {
        return currentHP > 0;
    }

    public void receiveDamage(int damage) {

        currentHP -= damage;
        if (currentHP < 0) {
            currentHP = 0;
        }
    }

    public void heal(int amount) {

        currentHP += amount;
        if (currentHP > maxHP) {
            currentHP = maxHP;
        }
    }

    public boolean consumeMP(int amount) {

        if (currentMP < amount) {
            return false;
        }

        currentMP -= amount;
        return true;
    }

    public int getMagicAttack() {
        return magicAttack;
    }

    public int getMagicDefense() {
        return magicDefense;
    }

}
