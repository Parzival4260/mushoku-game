package character;

public class Skill {

    private String id;
    private String name;
    private int power;
    private SkillType type;
    private boolean magical;

    private StatModifier buffModifier;

    private boolean special;
    private int cooldown;
    private int currentCooldown;
    private int energyCost;
    private int maxUsesPerBattle;
    private int usesThisBattle;

    private boolean multiTarget;

    public Skill(String id,
            String name,
            int power,
            SkillType type,
            boolean magical) {

        this.id = id;
        this.name = name;
        this.power = power;
        this.type = type;
        this.magical = magical;

        this.special = false;
        this.cooldown = 0;
        this.currentCooldown = 0;
        this.energyCost = 0;
        this.maxUsesPerBattle = Integer.MAX_VALUE;
        this.usesThisBattle = 0;
        this.multiTarget = false;
    }

    // ===== CONFIGURACIÓN ESPECIAL =====
    public void setSpecial(int energyCost,
            int cooldown,
            int maxUses) {

        this.special = true;
        this.energyCost = energyCost;
        this.cooldown = cooldown;
        this.maxUsesPerBattle = maxUses;
    }

    public void setBuff(StatModifier modifier) {
        this.buffModifier = modifier;
    }

    // ===== USO EN COMBATE =====
    public boolean canUse(int currentEnergy) {

        if (special) {
            if (currentCooldown > 0) {
                return false;
            }
            if (currentEnergy < energyCost) {
                return false;
            }
            if (usesThisBattle >= maxUsesPerBattle) {
                return false;
            }
        }

        return true;
    }

    public void registerUse() {
        usesThisBattle++;

        if (special) {
            currentCooldown = cooldown;
        }
    }

    public void reduceCooldown() {
        if (currentCooldown > 0) {
            currentCooldown--;
        }
    }

    public void resetBattleUses() {
        usesThisBattle = 0;
        currentCooldown = 0;
    }

    // ===== GETTERS =====
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }

    public SkillType getType() {
        return type;
    }

    public boolean isMagical() {
        return magical;
    }

    public boolean isSpecial() {
        return special;
    }

    public int getEnergyCost() {
        return energyCost;
    }

    public StatModifier getBuffModifier() {
        return buffModifier;
    }

    public void setMultiTarget(boolean value) {
        this.multiTarget = value;
    }

    public boolean isMultiTarget() {
        return multiTarget;
    }
}
