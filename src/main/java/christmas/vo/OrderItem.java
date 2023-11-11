package christmas.vo;

import christmas.domain.menu.Menu;

public class OrderItem {
    private final Menu menu;
    private final MenuQuantity quantity;

    private OrderItem(Menu menu, MenuQuantity quantity) {
        this.menu = menu;
        this.quantity = quantity;
    }

    public static OrderItem of(Menu menu, MenuQuantity menuQuantity) {
        return new OrderItem(menu, menuQuantity);
    }

    public int calculateTotalPrice() {
        return menu.calculatePrice(quantity);
    }
}
