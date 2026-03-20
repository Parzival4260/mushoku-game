package worldMap;

import character.*;
import java.util.*;

public class AdventurersGuild {

    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();

    public void openGuild(Party party) {

        boolean exit = false;

        while (!exit) {

            System.out.println("\n===== GREMIO DE AVENTUREROS =====");
            System.out.println("Oro: " + party.getGold());
            System.out.println("1. Curarse (Gratis)");
            System.out.println("2. Tienda");
            System.out.println("3. Salir");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    healParty(party);
                    break;
                case 2:
                    openShop(party);
                    break;
                case 3:
                    exit = true;
                    break;
            }
        }
    }

    private void healParty(Party party) {
        for (GameCharacter c : party.getMembers()) {
            c.getStats().heal(c.getStats().getMaxHP());
        }
        System.out.println("Todo el grupo ha sido curado.");
    }

    private void openShop(Party party) {

        System.out.println("\n===== TIENDA =====");
        System.out.println("Oro: " + party.getGold());

        List<Item> shopItems = new ArrayList<>();

        // Siempre disponibles
        shopItems.add(ItemDatabase.getItem("POTION_SMALL"));
        shopItems.add(ItemDatabase.getItem("ARMOR_CLOTH"));
        shopItems.add(ItemDatabase.getItem("RING_POWER"));

        // Probabilidades bajas
        if (random.nextInt(100) < 15) {
            shopItems.add(ItemDatabase.getItem("LEVEL_UP_STONE"));
        }

        if (random.nextInt(100) < 8) {
            shopItems.add(ItemDatabase.getItem("EQUIPMENT_CORE"));
        }

        if (random.nextInt(100) < 3) {
            shopItems.add(ItemDatabase.getItem("SKILL_RANK_CRYSTAL"));
        }

        for (int i = 0; i < shopItems.size(); i++) {
            System.out.println((i + 1) + ". " + shopItems.get(i).getName());
        }

        System.out.println("0. Salir");

        int option = scanner.nextInt();
        scanner.nextLine();

        if (option <= 0 || option > shopItems.size()) {
            return;
        }

        Item selected = shopItems.get(option - 1);
        int price = calculatePrice(selected);

        if (party.spendGold(price)) {
            party.getInventory().addItem(selected, 1);
            System.out.println("Comprado con éxito.");
        } else {
            System.out.println("No tienes suficiente oro.");
        }
    }

    private int calculatePrice(Item item) {

        switch (item.getRarity()) {
            case COMMON:
                return 50;
            case UNCOMMON:
                return 200;
            case RARE:
                return 1000;
            case EPIC:
                return 5000;
            case LEGENDARY:
                return 15000;
            case MYTHIC:
                return 50000;
            default:
                return 100;
        }
    }
}