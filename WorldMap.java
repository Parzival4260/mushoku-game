package worldMap;

import java.util.HashMap;
import java.util.Map;

public class WorldMap {

    private Map<String, MapGrid> maps = new HashMap<>();
    private Location playerLocation;

    public WorldMap() {
        createWorld();
    }

    private void createWorld() {

        // ===== MAPA 1: Japón (Acto 0) =====
        char[][] japan = {
                {'#','#','#','#','#','#','#','#','#','#'},
                {'#','.','.','.','.','.','.','.','.','#'},
                {'#','.','#','#','.','.','#','#','.','#'},
                {'#','.','.','.','.','.','.','.','.','#'},
                {'#','.','.','#','#','.','#','#','.','#'},
                {'#','.','.','.','.','.','.','.','.','#'},
                {'#','.','.','.','.','#','#','.','.','#'},
                {'#','.','.','.','.','.','.','.','.','#'},
                {'#','.','.','.','.','.','.','.','T','#'},
                {'#','#','#','#','#','#','#','#','#','#'}
        };

        MapGrid japanMap = new MapGrid("Japón - Ciudad", japan);

        // Trigger del accidente
        japanMap.addTrigger(8, 8,
                new Trigger("EVENT", "VISION", 0, 0));

        maps.put("JAPON", japanMap);

        // ===== MAPA 2: Aldea Buena (Acto 1) =====
        char[][] buena = {
                {'#','#','#','#','#','#','#','#','#','#'},
                {'#','.','.','.','.','.','.','.','.','#'},
                {'#','.','.','#','#','.','.','#','.','#'},
                {'#','.','.','.','.','.','.','.','.','#'},
                {'#','.','#','#','.','.','#','#','.','#'},
                {'#','.','.','.','.','.','.','.','.','#'},
                {'#','.','.','.','.','#','#','.','.','#'},
                {'#','.','.','.','.','.','.','.','.','#'},
                {'#','.','.','.','.','.','.','.','D','#'},
                {'#','#','#','#','#','#','#','#','#','#'}
        };

        MapGrid buenaMap = new MapGrid("Aldea Buena", buena);

        maps.put("BUENA", buenaMap);

        // Posición inicial
        playerLocation = new Location(japanMap, 1, 1);
    }

    public Location getPlayerLocation() {
        return playerLocation;
    }

    public void changeMap(String mapName, int x, int y) {

        MapGrid newMap = maps.get(mapName);

        if (newMap != null) {
            playerLocation.setCurrentMap(newMap);
            playerLocation.setPlayerPosition(x, y);
        }
    }
}
