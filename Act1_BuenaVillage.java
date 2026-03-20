package story;

import character.Party;
import worldMap.WorldMap;

public class Act1_BuenaVillage {

    public static void start(Party party,
                             WorldMap worldMap,
                             StoryManager storyManager) {

        System.out.println("=================================");
        System.out.println("ACTO 1 — ALDEA BUENA");
        System.out.println("=================================");

        System.out.println("Rudeus comienza su nueva vida.");
        System.out.println("Entrena magia básica.");
        System.out.println("Conoce a Roxy.");
        System.out.println("La vida parece tranquila...");

        storyManager.getFlags().activate("ACT1_STARTED");

        // Aquí luego pondremos:
        // entrenamiento
        // Sylphy
        // Eris
        // Evento de teletransporte
    }
}

