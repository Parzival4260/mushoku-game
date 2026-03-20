package character;

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

    public double getAttackMultiplier() {
        return attackMultiplier;
    }

    public double getDefenseMultiplier() {
        return defenseMultiplier;
    }

    public double getSpeedMultiplier() {
        return speedMultiplier;
    }
}
