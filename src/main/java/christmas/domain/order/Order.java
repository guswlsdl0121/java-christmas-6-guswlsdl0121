package christmas.domain.order;

import christmas.domain.menu.Menu;
import christmas.vo.MenuQuantity;
import java.util.EnumMap;
import java.util.Map;

public class Order {
    private final EnumMap<Menu, MenuQuantity> menuOrders;

    private Order() {
        this.menuOrders = new EnumMap<>(Menu.class);
    }

    public static Order create() {
        return new Order();
    }

    public void addMenu(Menu menu, MenuQuantity quantity) {
        menuOrders.put(menu, quantity);
    }

    public int calculateTotalPrice() {
        return menuOrders.entrySet().stream()
                .mapToInt(this::calculatePrice)
                .sum();
    }

    private int calculatePrice(Map.Entry<Menu, MenuQuantity> entry) {
        return entry.getKey().calculatePrice(entry.getValue());
    }
}
