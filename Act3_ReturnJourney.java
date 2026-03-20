package story;

import character.Party;
import worldMap.WorldMap;

public class Act3_ReturnJourney {

    public static void start(Party party,
                             WorldMap worldMap,
                             StoryManager storyManager) {

        System.out.println("=================================");
        System.out.println("ACTO 3 — EL REGRESO");
        System.out.println("=================================");

        System.out.println("El viaje de regreso comienza...");
        System.out.println("Nuevos enemigos aparecen.");

        storyManager.getFlags().activate("ACT3_STARTED");
    }
}

