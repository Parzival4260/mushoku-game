package worldMap;

public class Location {

    private MapGrid currentMap;
    private int playerX;
    private int playerY;

    public Location(MapGrid map, int x, int y) {
        this.currentMap = map;
        this.playerX = x;
        this.playerY = y;
    }

    public MapGrid getCurrentMap() {
        return currentMap;
    }

    public void setCurrentMap(MapGrid currentMap) {
        this.currentMap = currentMap;
    }

    public int getPlayerX() {
        return playerX;
    }

    public int getPlayerY() {
        return playerY;
    }

    public void setPlayerPosition(int x, int y) {
        this.playerX = x;
        this.playerY = y;
    }
}
