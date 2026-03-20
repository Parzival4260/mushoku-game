package core;

public enum Difficulty {

    AVENTURERO(0.8, 0.85, 1.2),
    ESPADACHIN(1.0, 1.0, 1.0),
    RENACIDO(1.4, 1.5, 0.8);

    private final double enemyDamageMultiplier;
    private final double enemyHealthMultiplier;
    private final double dropRateMultiplier;

    Difficulty(double dmg, double hp, double drop) {
        this.enemyDamageMultiplier = dmg;
        this.enemyHealthMultiplier = hp;
        this.dropRateMultiplier = drop;
    }

    public double getEnemyDamageMultiplier() {
        return enemyDamageMultiplier;
    }

    public double getEnemyHealthMultiplier() {
        return enemyHealthMultiplier;
    }

    public double getDropRateMultiplier() {
        return dropRateMultiplier;
    }
}
