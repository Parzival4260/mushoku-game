package character;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Party implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<GameCharacter> members;
    private Inventory inventory;

    // Sistema de oro
    private int gold;
    private boolean infiniteGold;

    // NUEVO: líder activo
    private GameCharacter activeLeader;

    // =========================
    // CONSTRUCTORES
    // =========================

    public Party() {
        members = new ArrayList<>();
        inventory = new Inventory();
        gold = 0;
        infiniteGold = false;
    }

    public Party(List<GameCharacter> characters) {
        this.members = new ArrayList<>(characters);
        this.inventory = new Inventory();
        this.gold = 0;
        this.infiniteGold = false;

        if (!members.isEmpty()) {
            activeLeader = members.get(0);
        }
    }

    // =========================
    // MIEMBROS
    // =========================

    public void addMember(GameCharacter character) {
        members.add(character);

        if (activeLeader == null) {
            activeLeader = character;
        }
    }

    public List<GameCharacter> getMembers() {
        return members;
    }

    public List<GameCharacter> getAliveMembers() {

        List<GameCharacter> alive = new ArrayList<>();

        for (GameCharacter c : members) {
            if (c.getStats().isAlive()) {
                alive.add(c);
            }
        }

        return alive;
    }

    public boolean isDefeated() {
        return getAliveMembers().isEmpty();
    }

    // =========================
    // INVENTARIO
    // =========================

    public Inventory getInventory() {
        return inventory;
    }

    // =========================
    // SISTEMA DE ORO
    // =========================

    public int getGold() {
        return gold;
    }

    public void addGold(int amount) {

        if (infiniteGold)
            return;

        gold += amount;
    }

    public boolean spendGold(int amount) {

        if (infiniteGold)
            return true;

        if (gold < amount)
            return false;

        gold -= amount;
        return true;
    }

    // =========================
    // CHEAT ORO INFINITO
    // =========================

    public void setInfiniteGold(boolean value) {
        this.infiniteGold = value;
    }

    public boolean isInfiniteGold() {
        return infiniteGold;
    }

    // =========================
    // LÍDER ACTIVO
    // =========================

    public void setActiveLeader(GameCharacter leader) {
        this.activeLeader = leader;
        System.out.println("Nuevo protagonista: " + leader.getName());
    }

    public GameCharacter getActiveLeader() {
        return activeLeader;
    }
}