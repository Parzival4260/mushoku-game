package story;

import character.Party;
import worldMap.WorldMap;

public class Act4_MagicAcademy {

    public static void start(Party party,
                             WorldMap worldMap,
                             StoryManager storyManager) {

        System.out.println("=================================");
        System.out.println("ACTO 4 — ACADEMIA DE MAGIA");
        System.out.println("=================================");

        System.out.println("Rudeus ingresa a la Academia.");
        System.out.println("Viejos conocidos reaparecen.");

        storyManager.getFlags().activate("ACT4_STARTED");
    }
}

