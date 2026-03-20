package character;

import java.util.HashMap;
import java.util.Map;

public class Item {

    private String id;
    private String name;
    private ItemType type;
    private boolean stackable;
    private int maxStack;
    private ItemRarity rarity;

    private Map<StatType, Integer> statBonuses;
    private String linkedSkillId;

    // 🔥 NUEVO
    private int healAmount;

    public Item(String id, String name,
                ItemType type,
                boolean stackable,
                int maxStack,
                ItemRarity rarity) {

        this.id = id;
        this.name = name;
        this.type = type;
        this.stackable = stackable;
        this.maxStack = maxStack;
        this.rarity = rarity;

        this.statBonuses = new HashMap<>();
        this.healAmount = 0;
    }

    // =========================
    // HEAL
    // =========================

    public void setHealAmount(int amount) {
        this.healAmount = amount;
    }

    public int getHealAmount() {
        return healAmount;
    }

    // =========================
    // STATS
    // =========================

    public void addStatBonus(StatType stat, int value) {
        statBonuses.put(stat, value);
    }

    public Map<StatType, Integer> getStatBonuses() {
        return statBonuses;
    }

    // =========================
    // SCROLL
    // =========================

    public void setLinkedSkillId(String id) {
        this.linkedSkillId = id;
    }

    public String getLinkedSkillId() {
        return linkedSkillId;
    }

    // =========================
    // GETTERS
    // =========================

    public String getId() { return id; }
    public String getName() { return name; }
    public ItemType getType() { return type; }
    public boolean isStackable() { return stackable; }
    public int getMaxStack() { return maxStack; }
    public ItemRarity getRarity() { return rarity; }
}