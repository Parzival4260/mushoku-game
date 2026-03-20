package character;

public class BossCharacter extends GameCharacter {

    private int phase;

    public BossCharacter(String name, Stats stats, Element element) {
        super(name, stats, element);
        phase = 1;
    }

    public void checkPhaseChange() {

        int hpPercent = (getStats().getCurrentHP() * 100) / getStats().getMaxHP();

        if (hpPercent <= 50 && phase == 1) {
            phase = 2;
            System.out.println(getName() + " entra en FASE 2!");
            addBuff(new StatModifier(StatType.ATTACK, 50, 0.2, 99));
        }

        if (hpPercent <= 20 && phase == 2) {
            phase = 3;
            System.out.println(getName() + " entra en FASE FINAL!");
            addBuff(new StatModifier(StatType.SPEED, 30, 0.3, 99));
        }
    }
}
