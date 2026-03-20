package character;

import java.util.HashMap;
import java.util.Map;

public class SpecialSkillDatabase {

    private static final Map<String, Skill> skills = new HashMap<>();

    static {

        // =====================================================
        // 🔮 MAGIAS ESPECIALES
        // =====================================================

        addSpecialMagic("SPECIAL_METEOR_SUPREME", "Meteor Supremo", 350);
        addSpecialMagic("SPECIAL_TIME_ERASE", "Time Erase", 300);
        addSpecialMagic("SPECIAL_DRAGON_ROAR", "Rugido del Dragón", 320);
        addSpecialMagic("SPECIAL_ABYSS_GATE", "Puerta del Abismo", 400);
        addSpecialMagic("SPECIAL_INFERNAL_NOVA", "Nova Infernal", 370);
        addSpecialMagic("SPECIAL_FROZEN_APOCALYPSE", "Apocalipsis Helado", 360);
        addSpecialMagic("SPECIAL_DIVINE_JUDGMENT", "Juicio Divino", 380);
        addSpecialMagic("SPECIAL_VOID_COLLAPSE", "Colapso del Vacío", 420);
        addSpecialMagic("SPECIAL_DRAGON_GOD_MAGIC", "Magia Dios Dragón", 450);
        addSpecialMagic("SPECIAL_NOCHANT_OVERFLOW", "Overflow Sin Canto", 390);

        // Buff mágicos especiales

        addSpecialBuff("SPECIAL_ARCANE_OVERDRIVE",
                "Arcane Overdrive",
                StatType.ATTACK,
                120,
                5);

        addSpecialBuff("SPECIAL_ABSOLUTE_BARRIER",
                "Barrera Absoluta",
                StatType.DEFENSE,
                150,
                4);


        // =====================================================
        // ⚔ FÍSICAS ESPECIALES
        // =====================================================

        addSpecialPhysical("SPECIAL_GODSPEED_EXTREME", "Godspeed Extremo", 380);
        addSpecialPhysical("SPECIAL_DRAGON_EXECUTION", "Ejecución Dragón", 420);
        addSpecialPhysical("SPECIAL_TOUKI_OVERLOAD", "Touki Overload", 360);
        addSpecialPhysical("SPECIAL_TITAN_SUNDER", "Titan Sunder", 400);
        addSpecialPhysical("SPECIAL_WAR_GOD_DESCENT", "Descenso del Dios de la Guerra", 450);
        addSpecialPhysical("SPECIAL_BEAST_KING_RAMPAGE", "Furia del Rey Bestia", 370);
        addSpecialPhysical("SPECIAL_SHADOW_ASSASSINATION", "Asesinato de Sombras", 390);
        addSpecialPhysical("SPECIAL_DRAGON_BREAKER", "Dragon Breaker Final", 430);
        addSpecialPhysical("SPECIAL_BLOODLUST_SURGE", "Bloodlust Surge", 350);
        addSpecialPhysical("SPECIAL_INFINITY_SLASH", "Infinity Slash", 410);

        // Buff físicos especiales

        addSpecialBuff("SPECIAL_DRAGON_AURA",
                "Aura del Dragón Supremo",
                StatType.ATTACK,
                150,
                5);

        addSpecialBuff("SPECIAL_IMMORTAL_BODY",
                "Cuerpo Inmortal",
                StatType.DEFENSE,
                200,
                4);
    }

    // =====================================================
    // MÉTODOS AUXILIARES
    // =====================================================

    private static void addSpecialMagic(String id, String name, int power) {

        Skill skill = new Skill(id, name,
                power,
                SkillType.DAMAGE,
                true);

        skills.put(id, skill);
    }

    private static void addSpecialPhysical(String id, String name, int power) {

        Skill skill = new Skill(id, name,
                power,
                SkillType.DAMAGE,
                false);

        skills.put(id, skill);
    }

    private static void addSpecialBuff(String id,
                                       String name,
                                       StatType stat,
                                       int value,
                                       int turns) {

        Skill skill = new Skill(id, name,
                0,
                SkillType.BUFF,
                false);

        skill.setBuff(
                new StatModifier(stat, value, 0.40, turns)
        );

        skills.put(id, skill);
    }

    public static Skill getSkill(String id) {
        return skills.get(id);
    }
}
