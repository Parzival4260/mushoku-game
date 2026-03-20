package character;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Inventory {

    private boolean cheatMode = false;

    private List<InventorySlot> slots;
    private final int maxSlots = 100;

    public Inventory() {
        slots = new ArrayList<>();
    }

    // =========================
    // CHEAT MODE
    // =========================

    public void setCheatMode(boolean value) {
        this.cheatMode = value;
    }

    public boolean isCheatMode() {
        return cheatMode;
    }

    // =========================
    // ADD ITEM
    // =========================

    public boolean addItem(Item item, int quantity) {

        if (item.getType() == ItemType.KEY_ITEM) {
            return true; // No ocupa espacio
        }

        if (item.isStackable()) {
            for (InventorySlot slot : slots) {
                if (slot.getItem().getId().equals(item.getId())
                        && slot.getQuantity() < item.getMaxStack()) {

                    if (!cheatMode) {
                        slot.addQuantity(quantity);
                    } else {
                        slot.addQuantity(item.getMaxStack()); // infinito visual
                    }
                    return true;
                }
            }
        }

        if (slots.size() >= maxSlots && !cheatMode) {
            System.out.println("Inventario lleno.");
            return false;
        }

        int finalQuantity = cheatMode ? item.getMaxStack() : quantity;

        slots.add(new InventorySlot(item, finalQuantity));
        return true;
    }

    // =========================
    // REMOVE ITEM
    // =========================

    public void removeItem(String itemId, int quantity) {

        if (cheatMode) {
            return; // nunca elimina
        }

        Iterator<InventorySlot> iterator = slots.iterator();

        while (iterator.hasNext()) {

            InventorySlot slot = iterator.next();

            if (slot.getItem().getId().equals(itemId)) {

                slot.removeQuantity(quantity);

                if (slot.isEmpty()) {
                    iterator.remove();
                }

                return;
            }
        }
    }

    // =========================
    // GETTERS
    // =========================

    public List<InventorySlot> getSlots() {
        return slots;
    }

    public void printInventory() {

        System.out.println("===== INVENTARIO =====");

        if (slots.isEmpty()) {
            System.out.println("Vacío.");
        }

        for (int i = 0; i < slots.size(); i++) {
            InventorySlot slot = slots.get(i);
            System.out.println((i + 1) + ". "
                    + slot.getItem().getName()
                    + " x" + slot.getQuantity());
        }

        System.out.println("======================");
    }
}