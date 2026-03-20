package story;

import character.*;
import worldMap.WorldMap;
import story.StoryManager;
import BattleSystem.BattleSystem;
import core.Difficulty;

import java.util.Scanner;

public class Act0_Prologue {

    public static void start(Party party,
                             WorldMap worldMap,
                             StoryManager storyManager,
                             Difficulty difficulty) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=======================================");
        System.out.println("        ACTO 0 — PRÓLOGO");
        System.out.println("=======================================\n");

        // ===============================
        // VIDA PASADA
        // ===============================

        System.out.println("Eras un hombre sin propósito...");
        System.out.println("Encerrado... arrepentido...");
        System.out.println("Sin haber hecho nada con tu vida.");
        System.out.println("\nUn día...");
        System.out.println("Un camión se acerca...");
        System.out.println("Y todo termina.");
        pause(scanner);

        System.out.println("\nOscuridad...");
        System.out.println("Pero tu conciencia sigue viva...");
        pause(scanner);

        // ===============================
        // TUTORIAL CONTROLES
        // ===============================

        System.out.println("\n===== TUTORIAL =====");
        System.out.println("Controles de Exploración:");
        System.out.println("W = Arriba");
        System.out.println("S = Abajo");
        System.out.println("A = Izquierda");
        System.out.println("D = Derecha");
        System.out.println("\nEn los menús:");
        System.out.println("Escribe el número de la opción y presiona ENTER.");
        pause(scanner);

        // ===============================
        // MINI BATALLA TUTORIAL
        // ===============================

        System.out.println("\nAntes de renacer...");
        System.out.println("Debes enfrentar tus propios miedos.");

        GameCharacter shadow = new GameCharacter(
                "Sombra Interior",
                new Stats(200, 50,
                          40, 30,
                          30, 20,
                          15),
                Element.DARK
        );

        shadow.setCharacterClass(GameCharacter.CharacterClass.DEMON);

        GameCharacter soul = new GameCharacter(
                "Alma Residual",
                new Stats(300, 100,
                          60, 40,
                          35, 30,
                          25),
                Element.LIGHT
        );

        Skill innerStrike = new Skill(
                "INNER_STRIKE",
                "Golpe Interior",
                10,
                SkillType.DAMAGE,
                false
        );

        soul.learnSkill(innerStrike);
        soul.equipSkill(innerStrike);

        Party tutorialPlayer = new Party();
        tutorialPlayer.addMember(soul);

        Party tutorialEnemy = new Party();
        tutorialEnemy.addMember(shadow);

        BattleSystem tutorialBattle = new BattleSystem(difficulty);
        tutorialBattle.startBattle(tutorialPlayer, tutorialEnemy);

        System.out.println("\nHas superado tu miedo...");
        pause(scanner);

        // ===============================
        // VISIÓN DE ORSTED
        // ===============================

        System.out.println("\nEl mundo se distorsiona...");
        System.out.println("Una visión invade tu mente...");
        System.out.println("Un hombre de cabellos blancos te observa...");
        System.out.println("Es el Dios Dragón... Orsted.");
        pause(scanner);

        GameCharacter rudeusVision = MainCharactersFactory.createRudeus();
        rudeusVision.getStats().setLevelSilently(50);

        GameCharacter orsted = MainCharactersFactory.createOrsted();
        orsted.getStats().setLevelSilently(60);

        Party visionPlayer = new Party();
        visionPlayer.addMember(rudeusVision);

        Party visionEnemy = new Party();
        visionEnemy.addMember(orsted);

        BattleSystem visionBattle = new BattleSystem(difficulty);
        visionBattle.startBattle(visionPlayer, visionEnemy);

        System.out.println("\nEl destino ya estaba escrito...");
        System.out.println("Todo se vuelve blanco...");
        pause(scanner);

        // ===============================
        // RENACIMIENTO
        // ===============================

        System.out.println("\nEscuchas una voz...");
        System.out.println("Has renacido en un nuevo mundo.");

        party.getMembers().clear();
        party.addMember(MainCharactersFactory.createRudeus());

        storyManager.getFlags().activate("BORN_AS_RUDEUS");
        storyManager.setCurrentAct(1);

        worldMap.changeMap("BUENA", 1, 1);

        System.out.println("\n===== ACTO 1 — ALDEA BUENA =====");
    }

    private static void pause(Scanner scanner) {
        System.out.println("\n(Presiona ENTER para continuar)");
        scanner.nextLine();
    }
}

