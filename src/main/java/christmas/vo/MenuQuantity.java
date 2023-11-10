package christmas.vo;

public final class MenuQuantity {
    private final int quantity;

    private MenuQuantity(int quantity) {
        this.quantity = quantity;
    }

    public static MenuQuantity from(int quantity) {
        return new MenuQuantity(quantity);
    }

    public int getQuantity() {
        return quantity;
    }
}
