package christmas.vo.order;

import christmas.domain.menu.Menu;

public record OrderItem(Menu menu, MenuQuantity quantity) {

    public int calculateTotalPrice() {
        return menu.calculatePrice(quantity);
    }
}
