package character;

import java.util.HashMap;
import java.util.Map;

public class ItemDatabase {

    private static final Map<String, Item> items = new HashMap<>();

    static {

        // =====================================================
        // OBJETOS CONSUMIBLES (CURACIÓN)
        // =====================================================

        addConsumable("POTION_SMALL", "Poción Pequeña", 100, ItemRarity.COMMON);
        addConsumable("POTION_MEDIUM", "Poción Mediana", 250, ItemRarity.UNCOMMON);
        addConsumable("POTION_LARGE", "Poción Grande", 500, ItemRarity.RARE);
        addConsumable("ELIXIR_SUPREME", "Elixir Supremo", 9999, ItemRarity.LEGENDARY);

        // =====================================================
        // OBJETOS ESPECIALES DE PROGRESIÓN
        // =====================================================

        addSpecial("LEVEL_UP_STONE", "Piedra de Ascensión", ItemRarity.EPIC);
        addSpecial("EQUIPMENT_CORE", "Núcleo de Mejora", ItemRarity.LEGENDARY);
        addSpecial("SKILL_RANK_CRYSTAL", "Cristal de Rango Supremo", ItemRarity.MYTHIC);

        // =====================================================
        // 30 EQUIPAMIENTOS BASE
        // =====================================================

        // ================= ARMADURAS (10) =================

        addArmor("ARMOR_CLOTH", "Ropa Básica", 5, 0, 0, ItemRarity.COMMON);
        addArmor("ARMOR_MAGE_ROBE", "Túnica de Mago", 15, 10, 0, ItemRarity.UNCOMMON);
        addArmor("ARMOR_ARCHMAGE", "Túnica Archimago", 25, 20, 5, ItemRarity.RARE);
        addArmor("ARMOR_LIGHT", "Armadura Ligera", 20, 0, 10, ItemRarity.UNCOMMON);
        addArmor("ARMOR_KNIGHT", "Armadura Caballero", 40, 5, -5, ItemRarity.RARE);
        addArmor("ARMOR_HEAVY", "Armadura Pesada", 55, 0, -10, ItemRarity.EPIC);
        addArmor("ARMOR_DRAGON", "Armadura Dragón", 70, 20, 0, ItemRarity.LEGENDARY);
        addArmor("ARMOR_DRAGON_GOD", "Armadura Dios Dragón", 100, 40, 10, ItemRarity.MYTHIC);
        addArmor("ARMOR_SHADOW", "Armadura de Sombras", 35, 25, 20, ItemRarity.EPIC);
        addArmor("ARMOR_SAINT", "Armadura Santa", 60, 30, 5, ItemRarity.LEGENDARY);

        // ================= ACCESORIOS (10) =================

        addAccessory("RING_POWER", "Anillo del Poder", StatType.ATTACK, 20, ItemRarity.RARE);
        addAccessory("RING_SPEED", "Anillo de Velocidad", StatType.SPEED, 20, ItemRarity.RARE);
        addAccessory("RING_DEFENSE", "Anillo Defensivo", StatType.DEFENSE, 25, ItemRarity.RARE);
        addAccessory("AMULET_MANA", "Amuleto de Maná", StatType.MAGIC_ATTACK, 15, ItemRarity.UNCOMMON);
        addAccessory("AMULET_TOUKI", "Amuleto de Touki", StatType.DEFENSE, 30, ItemRarity.EPIC);
        addAccessory("PENDANT_DRAGON", "Colgante Dragón", StatType.ATTACK, 35, ItemRarity.LEGENDARY);
        addAccessory("BRACELET_WIND", "Brazalete del Viento", StatType.SPEED, 30, ItemRarity.EPIC);
        addAccessory("CORE_MANA", "Núcleo de Maná", StatType.MAGIC_ATTACK, 40, ItemRarity.LEGENDARY);
        addAccessory("TALISMAN_LIGHT", "Talismán de Luz", StatType.DEFENSE, 35, ItemRarity.LEGENDARY);
        addAccessory("RELIC_GOD", "Reliquia Divina", StatType.ATTACK, 60, ItemRarity.MYTHIC);

        // ================= OJOS DEMONÍACOS (10) =================

        addDemonEye("DEMON_EYE_FUTURE", "Ojo del Futuro", 0, 40, 20);
        addDemonEye("DEMON_EYE_MANA", "Ojo de Maná", 30, 0, 0);
        addDemonEye("DEMON_EYE_DESTRUCTION", "Ojo de Destrucción", 50, 0, 0);
        addDemonEye("DEMON_EYE_CLARITY", "Ojo de Claridad", 0, 0, 40);
        addDemonEye("DEMON_EYE_ABYSS", "Ojo del Abismo", 70, 20, 0);
        addDemonEye("DEMON_EYE_SPEED", "Ojo de Percepción", 20, 0, 50);
        addDemonEye("DEMON_EYE_VOID", "Ojo del Vacío", 60, 30, 20);
        addDemonEye("DEMON_EYE_FLAME", "Ojo Ígneo", 45, 0, 10);
        addDemonEye("DEMON_EYE_FROST", "Ojo Glacial", 35, 20, 15);
        addDemonEye("DEMON_EYE_DRAGON", "Ojo Dragón Supremo", 90, 40, 30);

        // =====================================================
        // PERGAMINOS
        // =====================================================

        addScroll("SCROLL_FIREBALL", "Pergamino Fireball", "SKILL_FIREBALL");
        addScroll("SCROLL_LIGHTNING", "Pergamino Lightning", "SKILL_LIGHTNING");
        addScroll("SCROLL_STONE_SKIN", "Pergamino Stone Skin", "SKILL_STONE_SKIN");
        addScroll("SCROLL_GODSPEED", "Pergamino Godspeed", "SKILL_GODSPEED");
        addScroll("SCROLL_METEOR", "Pergamino Meteor", "SKILL_METEOR");
    }

    // =====================================================
    // MÉTODOS AUXILIARES
    // =====================================================

    private static void addConsumable(String id, String name, int healAmount, ItemRarity rarity) {

        Item item = new Item(id, name, ItemType.CONSUMABLE, true, 99, rarity);
        item.setHealAmount(healAmount);
        items.put(id, item);
    }

    private static void addSpecial(String id, String name, ItemRarity rarity) {

        Item item = new Item(id, name, ItemType.SPECIAL, false, 1, rarity);
        items.put(id, item);
    }

    private static void addArmor(String id, String name,
                                 int defense, int attack, int speed,
                                 ItemRarity rarity) {

        Item item = new Item(id, name, ItemType.EQUIPMENT, false, 1, rarity);

        item.addStatBonus(StatType.DEFENSE, defense);
        item.addStatBonus(StatType.ATTACK, attack);
        item.addStatBonus(StatType.SPEED, speed);

        items.put(id, item);
    }

    private static void addAccessory(String id, String name,
                                     StatType stat,
                                     int value,
                                     ItemRarity rarity) {

        Item item = new Item(id, name, ItemType.ACCESSORY, false, 1, rarity);
        item.addStatBonus(stat, value);
        items.put(id, item);
    }

    private static void addDemonEye(String id, String name,
                                    int attack,
                                    int defense,
                                    int speed) {

        Item item = new Item(id, name, ItemType.DEMON_EYE, false, 1, ItemRarity.LEGENDARY);

        item.addStatBonus(StatType.ATTACK, attack);
        item.addStatBonus(StatType.DEFENSE, defense);
        item.addStatBonus(StatType.SPEED, speed);

        items.put(id, item);
    }

    private static void addScroll(String id, String name, String linkedSkillId) {

        Item item = new Item(id, name, ItemType.SCROLL, false, 1, ItemRarity.EPIC);
        item.setLinkedSkillId(linkedSkillId);
        items.put(id, item);
    }

    public static Item getItem(String id) {
        return items.get(id);
    }
}