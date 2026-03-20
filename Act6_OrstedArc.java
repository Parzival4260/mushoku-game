package story;

import character.Party;
import worldMap.WorldMap;

public class Act6_OrstedArc {

    public static void start(Party party,
                             WorldMap worldMap,
                             StoryManager storyManager) {

        System.out.println("=================================");
        System.out.println("ACTO 6 — ALIANZA CON ORSTED");
        System.out.println("=================================");

        System.out.println("El destino cambia de rumbo.");

        storyManager.getFlags().activate("ACT6_STARTED");
    }
}
