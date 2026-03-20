package character;

public class StatModifier {

    private StatType type;
    private int flatBonus;          // +20
    private double percentBonus;    // +0.20 = 20%
    private int remainingTurns;

    public StatModifier(StatType type, int flatBonus, double percentBonus, int turns) {
        this.type = type;
        this.flatBonus = flatBonus;
        this.percentBonus = percentBonus;
        this.remainingTurns = turns;
    }

    public StatType getType() { return type; }
    public int getFlatBonus() { return flatBonus; }
    public double getPercentBonus() { return percentBonus; }

    public void decreaseTurn() {
        remainingTurns--;
    }

    public boolean isExpired() {
        return remainingTurns <= 0;
    }
}
