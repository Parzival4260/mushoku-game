package character;

public enum SkillRank {
    BASIC(1.0),
    INTERMEDIATE(1.1),
    ADVANCED(1.2),
    SAINT(1.3),
    KING(1.4),
    EMPEROR(1.5),
    GOD(1.7);

    private final double multiplier;

    SkillRank(double multiplier) {
        this.multiplier = multiplier;
    }

    public double getMultiplier() {
        return multiplier;
    }
}
