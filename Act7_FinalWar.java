package story;

import character.Party;
import worldMap.WorldMap;

public class Act7_FinalWar {

    public static void start(Party party,
                             WorldMap worldMap,
                             StoryManager storyManager) {

        System.out.println("=================================");
        System.out.println("ACTO 7 — GUERRA FINAL");
        System.out.println("=================================");

        System.out.println("El enfrentamiento definitivo comienza.");

        storyManager.getFlags().activate("ACT7_STARTED");
    }
}

