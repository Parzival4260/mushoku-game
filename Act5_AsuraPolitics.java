package story;

import character.Party;
import worldMap.WorldMap;

public class Act5_AsuraPolitics {

    public static void start(Party party,
                             WorldMap worldMap,
                             StoryManager storyManager) {

        System.out.println("=================================");
        System.out.println("ACTO 5 — POLÍTICA DE ASURA");
        System.out.println("=================================");

        System.out.println("Intrigas políticas sacuden el reino.");

        storyManager.getFlags().activate("ACT5_STARTED");
    }
}
