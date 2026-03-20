package character;

public class InventorySlot {

    private Item item;
    private int quantity;

    public InventorySlot(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public Item getItem() { return item; }
    public int getQuantity() { return quantity; }

    public void addQuantity(int amount) {
        quantity += amount;
        if (quantity > item.getMaxStack()) {
            quantity = item.getMaxStack();
        }
    }

    public void removeQuantity(int amount) {
        quantity -= amount;
        if (quantity < 0) {
            quantity = 0;
        }
    }

    public boolean isEmpty() {
        return quantity <= 0;
    }
}
