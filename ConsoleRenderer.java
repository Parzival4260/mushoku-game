package BattleSystem;

public class ConsoleRenderer {

    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";
    public static final String RED = "\u001B[31m";
    public static final String YELLOW = "\u001B[33m";
    public static final String CYAN = "\u001B[36m";

    public void printHUD(String name, int level, int hp, int maxHP, int mp, int maxMP) {

        System.out.println(CYAN + "============================" + RESET);
        System.out.println(name + " (Nv " + level + ")");
        System.out.println("HP: " + hp + "/" + maxHP);
        System.out.println("MP: " + mp + "/" + maxMP);
        System.out.println(CYAN + "============================" + RESET);
    }

    public void printEffectiveness(double multiplier) {

        if (multiplier >= 1.3) {
            System.out.println(GREEN + "¡Muy efectivo!" + RESET);
        } else if (multiplier <= 0.7) {
            System.out.println(RED + "No es muy efectivo..." + RESET);
        } else {
            System.out.println(YELLOW + "Efectividad normal." + RESET);
        }
    }
}