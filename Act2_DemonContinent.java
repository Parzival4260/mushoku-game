package story;

import character.Party;
import worldMap.WorldMap;

public class Act2_DemonContinent {

    public static void start(Party party,
                             WorldMap worldMap,
                             StoryManager storyManager) {

        System.out.println("=================================");
        System.out.println("ACTO 2 — CONTINENTE DEMONIO");
        System.out.println("=================================");

        System.out.println("Rudeus despierta en un lugar desconocido...");
        System.out.println("El Continente Demonio.");

        storyManager.getFlags().activate("ACT2_STARTED");

        worldMap.changeMap("DEMON_CONTINENT", 2, 2);
    }
}

