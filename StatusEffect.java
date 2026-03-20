package character;

public class StatusEffect {

    private StatusEffectType type;
    private int remainingTurns;

    public StatusEffect(StatusEffectType type, int duration) {
        this.type = type;
        this.remainingTurns = duration;
    }

    public StatusEffectType getType() {
        return type;
    }

    public int getRemainingTurns() {
        return remainingTurns;
    }

    public void decreaseTurn() {
        remainingTurns--;
    }

    public boolean isExpired() {
        return remainingTurns <= 0;
    }
}