package cheat;

import character.GameCharacter;
import character.Skill;

public class HiddenSystem {

    private static final String SECRET_CODE = "Orsted_TrueGod";

    public static void tryActivate(String input, GameCharacter character) {

        if (input.equals(SECRET_CODE)) {

            character.getStats().addExperience(Long.MAX_VALUE);

            for (Skill skill : character.getEquippedSkills()) {

                character.learnSkill(skill);

                // Subir skill a nivel 10 manualmente
                for (int i = 0; i < 100; i++) {
                    skill.registerUse();
                }
            }

            System.out.println("Modo Dios Activado.");
        }
    }
}
