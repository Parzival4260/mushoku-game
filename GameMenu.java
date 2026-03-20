package game;

import character.*;
import save.*;

import java.util.Scanner;

public class GameMenu {

    private Scanner scanner = new Scanner(System.in);

    public void openMenu(Party party, String currentChapter) {

        boolean exit = false;

        while (!exit) {

            System.out.println("\n===== MENÚ =====");
            System.out.println("1. Inventario");
            System.out.println("2. Equipo");
            System.out.println("3. Guardar");
            System.out.println("4. Salir");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {

                case 1:
                    party.getInventory().printInventory();
                    break;

                case 2:
                    showEquipment(party);
                    break;

                case 3:
                    System.out.println("Guarda desde el mapa usando comando 'save'");;
                    break;

                case 4:
                    exit = true;
                    break;
            }
        }
    }

    private void showEquipment(Party party) {

        for (GameCharacter c : party.getMembers()) {
            System.out.println("=== " + c.getName() + " ===");
            System.out.println("Clase: " + c.getCharacterClass());
            System.out.println("HP: " + c.getStats().getCurrentHP());
        }
    }
}
