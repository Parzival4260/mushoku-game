package save;

import character.Party;
import story.StoryManager;

public class SaveData {

    private Party party;
    private StoryManager storyManager;
    private String currentMap;
    private int playerX;
    private int playerY;

    public SaveData(Party party,
            StoryManager storyManager,
            String currentMap,
            int playerX,
            int playerY) {

        this.party = party;
        this.storyManager = storyManager;
        this.currentMap = currentMap;
        this.playerX = playerX;
        this.playerY = playerY;
    }

    public Party getParty() {
        return party;
    }

    public StoryManager getStoryManager() {
        return storyManager;
    }

    public String getCurrentMap() {
        return currentMap;
    }

    public int getPlayerX() {
        return playerX;
    }

    public int getPlayerY() {
        return playerY;
    }
}
