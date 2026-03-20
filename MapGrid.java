package worldMap;

import java.util.HashMap;
import java.util.Map;

public class MapGrid {

    private String name;
    private char[][] grid;
    private int width;
    private int height;

    private Map<String, Trigger> triggers = new HashMap<>();

    public MapGrid(String name, char[][] grid) {
        this.name = name;
        this.grid = grid;
        this.height = grid.length;
        this.width = grid[0].length;
    }

    public String getName() {
        return name;
    }

    public void addTrigger(int x, int y, Trigger trigger) {
        triggers.put(x + "," + y, trigger);
    }

    public Trigger getTrigger(int x, int y) {
        return triggers.get(x + "," + y);
    }

    public boolean isWalkable(int x, int y) {

        if (x < 0 || y < 0 || x >= width || y >= height)
            return false;

        return grid[y][x] != '#';
    }

    public void printMap(int playerX, int playerY) {

        System.out.println("\n=== Zona: " + name + " ===");

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {

                if (x == playerX && y == playerY) {
                    System.out.print("P ");
                } else {
                    System.out.print(grid[y][x] + " ");
                }
            }
            System.out.println();
        }
    }
}