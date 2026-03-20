package Main;

import core.GameEngine;
import core.Difficulty;
import java.util.Scanner;
import character.*;
import story.*;
import worldMap.*;
import save.*;

public class MushokuTenseiRpg {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== MUSHOKU TENSEI RPG =====");
            System.out.println("1. Nueva Partida");
            System.out.println("2. Cargar Partida");
            System.out.println("3. Salir");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {

                case 1:
                    startNewGame();
                    break;

                case 2:
                    loadGame();
                    break;

                case 3:
                    System.out.println("Hasta luego.");
                    System.exit(0);
                    break;
            }
        }
    }

// =========================
// NUEVA PARTIDA
// =========================
    private static void startNewGame() {

        Difficulty difficulty = chooseDifficulty();

        WorldMap worldMap = new WorldMap();
        Party party = new Party();
        StoryManager storyManager = new StoryManager();

// Rudeus inicial (renacido)
        GameCharacter rudeus = MainCharactersFactory.createRudeus();
        party.addMember(rudeus);

// ACTO 0
        storyManager.startAct0(party, worldMap, difficulty);

        WorldExplorer explorer = new WorldExplorer(
                worldMap,
                difficulty,
                party,
                storyManager
        );

        explorer.startExploration();
    }

// =========================
// CARGAR PARTIDA
// =========================
    private static void loadGame() {

        SaveData data = SaveManager.loadGame();

        if (data == null) {
            return;
        }

        WorldMap worldMap = new WorldMap();
        worldMap.changeMap(
                data.getCurrentMap(),
                data.getPlayerX(),
                data.getPlayerY()
        );

        WorldExplorer explorer = new WorldExplorer(
                worldMap,
                Difficulty.ESPADACHIN,
                data.getParty(),
                data.getStoryManager()
        );

        explorer.startExploration();
    }

// =========================
// DIFICULTAD
// =========================
    private static Difficulty chooseDifficulty() {

        System.out.println("\nSelecciona dificultad:");
        System.out.println("1. Fácil");
        System.out.println("2. Normal");
        System.out.println("3. Difícil");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                return Difficulty.AVENTURERO;
            case 3:
                return Difficulty.RENACIDO;
            default:
                return Difficulty.ESPADACHIN;
        }
    }
}
