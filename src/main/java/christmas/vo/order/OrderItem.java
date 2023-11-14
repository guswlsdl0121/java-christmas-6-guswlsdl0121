package christmas.vo.order;

import christmas.domain.Menu;

public record OrderItem(Menu menu, MenuQuantity quantity) {

    public int calculateTotalPrice() {
        return menu.calculatePrice(quantity);
    }

    public boolean isDessert() {
        return menu.isDessert();
    }

    public boolean isMain() {
        return menu.isMain();
    }

    public boolean isBeverageOrder() {
        return menu.isBeverage();
    }

    public String getMenuName() {
        return menu.getMenuName();
    }

    public String getKoreanName() {
        return menu.getKoranName();
    }

    public int getQuantity() {
        return quantity.quantity();
    }

    public int calculateDiscount(int discountPerItem) {
        return quantity.quantity() * discountPerItem;
    }
}
