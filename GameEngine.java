package core;

import character.Party;
import story.StoryManager;
import worldMap.WorldExplorer;
import worldMap.WorldMap;

public class GameEngine {

    private Difficulty difficulty;

    public GameEngine(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public void startWorld() {

        System.out.println("=== Mushoku Tensei RPG ===");
        System.out.println("Dificultad: " + difficulty);
        System.out.println();

        WorldMap worldMap = new WorldMap(); // 👈 FALTABA ESTO

        Party party = new Party();
        StoryManager storyManager = new StoryManager();
        
        WorldExplorer explorer = new WorldExplorer(worldMap, difficulty, party, storyManager);
        explorer.startExploration();
    }
}
