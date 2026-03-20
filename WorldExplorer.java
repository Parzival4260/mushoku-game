package worldMap;

import java.util.Scanner;

import character.*;
import core.Difficulty;
import story.StoryManager;
import save.*;

public class WorldExplorer {

    private WorldMap worldMap;
    private Scanner scanner;
    private Difficulty difficulty;

    private StoryManager storyManager;
    private Party party;

    public WorldExplorer(WorldMap worldMap,
            Difficulty difficulty,
            Party party,
            StoryManager storyManager) {

        this.worldMap = worldMap;
        this.difficulty = difficulty;
        this.party = party;
        this.storyManager = storyManager;
        this.scanner = new Scanner(System.in);
    }

    // =========================
    // EXPLORACIÓN
    // =========================
    public void startExploration() {

        while (true) {

            Location location = worldMap.getPlayerLocation();
            MapGrid map = location.getCurrentMap();

            map.printMap(location.getPlayerX(), location.getPlayerY());

            String input = scanner.nextLine().toLowerCase();

            int newX = location.getPlayerX();
            int newY = location.getPlayerY();

            switch (input) {
                case "w":
                    newY--;
                    break;
                case "s":
                    newY++;
                    break;
                case "a":
                    newX--;
                    break;
                case "d":
                    newX++;
                    break;
                case "save":
                    saveGame();
                    continue;
                default:
                    continue;
            }

            if (map.isWalkable(newX, newY)) {

                location.setPlayerPosition(newX, newY);

                Trigger trigger = map.getTrigger(newX, newY);

                if (trigger != null) {
                    handleTrigger(trigger);
                }
            }
        }
    }

    // =========================
    // TRIGGERS
    // =========================
    private void handleTrigger(Trigger trigger) {

        if (trigger.getType().equals("TELEPORT")) {

            worldMap.changeMap(
                    trigger.getTargetMap(),
                    trigger.getTargetX(),
                    trigger.getTargetY()
            );
        }

        if (trigger.getType().equals("LEAVE_VILLAGE")) {
            storyManager.setCurrentAct(2);
            storyManager.startCurrentAct(party, worldMap, difficulty);
        }

    }

    // =========================
    // GUARDAR
    // =========================
    private void saveGame() {

        Location loc = worldMap.getPlayerLocation();

        SaveData data = new SaveData(
                party,
                storyManager,
                loc.getCurrentMap().getName(),
                loc.getPlayerX(),
                loc.getPlayerY()
        );

        SaveManager.saveGame(data);
    }
}
