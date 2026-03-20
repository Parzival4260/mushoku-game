package character;

import java.util.HashMap;
import java.util.Map;

public class SkillDatabase {

    private static final Map<String, Skill> skills = new HashMap<>();

    static {

        // =====================================================
        // 🔮 20 MAGIAS BASE
        // =====================================================

        addMagic("SKILL_FIREBALL", "Fireball", 120);
        addMagic("SKILL_FLAME_WAVE", "Flame Wave", 140);
        addMagic("SKILL_LIGHTNING", "Lightning", 130);
        addMagic("SKILL_THUNDER_STORM", "Thunder Storm", 160);
        addMagic("SKILL_STONE_CANNON", "Stone Cannon", 150);
        addMagic("SKILL_EARTH_SPIKE", "Earth Spike", 130);
        addMagic("SKILL_WATER_BLAST", "Water Blast", 120);
        addMagic("SKILL_WATER_PRISON", "Water Prison", 110);
        addMagic("SKILL_WIND_CUTTER", "Wind Cutter", 125);
        addMagic("SKILL_TORNADO", "Tornado", 170);
        addMagic("SKILL_ICE_SHARD", "Ice Shard", 130);
        addMagic("SKILL_BLIZZARD", "Blizzard", 180);
        addMagic("SKILL_DARK_SPHERE", "Dark Sphere", 150);
        addMagic("SKILL_SHADOW_BURST", "Shadow Burst", 170);
        addMagic("SKILL_LIGHT_BEAM", "Light Beam", 160);
        addMagic("SKILL_HOLY_JUDGMENT", "Holy Judgment", 190);

        // Defensivas mágicas

        addBuffSkill("SKILL_STONE_SKIN", "Stone Skin",
                StatType.DEFENSE, 40, 3);

        addBuffSkill("SKILL_MAGIC_BARRIER", "Magic Barrier",
                StatType.DEFENSE, 60, 2);

        addBuffSkill("SKILL_HASTE", "Haste",
                StatType.SPEED, 40, 3);

        addBuffSkill("SKILL_MANA_BOOST", "Mana Boost",
                StatType.ATTACK, 30, 4);


        // =====================================================
        // ⚔ 20 ATAQUES FÍSICOS BASE
        // =====================================================

        addPhysical("SKILL_POWER_STRIKE", "Power Strike", 130);
        addPhysical("SKILL_DOUBLE_SLASH", "Double Slash", 140);
        addPhysical("SKILL_HEAVY_SMASH", "Heavy Smash", 160);
        addPhysical("SKILL_BLADE_RUSH", "Blade Rush", 150);
        addPhysical("SKILL_WHIRLWIND", "Whirlwind", 170);
        addPhysical("SKILL_CRITICAL_THRUST", "Critical Thrust", 180);
        addPhysical("SKILL_SHOCKWAVE", "Shockwave", 150);
        addPhysical("SKILL_RISING_CUT", "Rising Cut", 140);
        addPhysical("SKILL_DRAGON_FANG", "Dragon Fang", 200);
        addPhysical("SKILL_TOUKI_BURST", "Touki Burst", 190);

        // Buff físicos

        addBuffSkill("SKILL_BATTLE_FOCUS", "Battle Focus",
                StatType.ATTACK, 50, 3);

        addBuffSkill("SKILL_IRON_BODY", "Iron Body",
                StatType.DEFENSE, 50, 3);

        addBuffSkill("SKILL_WAR_CRY", "War Cry",
                StatType.ATTACK, 60, 2);

        addBuffSkill("SKILL_EVASION_STEP", "Evasion Step",
                StatType.SPEED, 50, 2);

        addPhysical("SKILL_TITAN_BREAKER", "Titan Breaker", 210);
        addPhysical("SKILL_FURY_COMBO", "Fury Combo", 180);
        addPhysical("SKILL_GALE_SLASH", "Gale Slash", 160);
        addPhysical("SKILL_STORM_CRUSH", "Storm Crush", 190);
        addPhysical("SKILL_BEAST_STRIKE", "Beast Strike", 170);
        addPhysical("SKILL_GUARD_BREAK", "Guard Break", 175);
    }

    // =====================================================
    // MÉTODOS AUXILIARES
    // =====================================================

    private static void addMagic(String id, String name, int power) {
        Skill skill = new Skill(id, name, power,
                SkillType.DAMAGE, true);
        skills.put(id, skill);
    }

    private static void addPhysical(String id, String name, int power) {
        Skill skill = new Skill(id, name, power,
                SkillType.DAMAGE, false);
        skills.put(id, skill);
    }

    private static void addBuffSkill(String id,
                                     String name,
                                     StatType stat,
                                     int value,
                                     int turns) {

        Skill skill = new Skill(id, name, 0,
                SkillType.BUFF, false);

        skill.setBuff(new StatModifier(stat, value, 0.20, turns));

        skills.put(id, skill);
    }

    public static Skill getSkill(String id) {
        return skills.get(id);
    }
}