package game;

import java.util.Scanner;

public class MainMenu {

    private Scanner scanner = new Scanner(System.in);

    public int showMenu() {

        System.out.println("===== MUSHOKU TENSEI RPG =====");
        System.out.println("1. Nueva Partida");
        System.out.println("2. Cargar Partida");
        System.out.println("3. Opciones");
        System.out.println("4. Salir");

        int option = scanner.nextInt();
        scanner.nextLine();

        return option;
    }
}
