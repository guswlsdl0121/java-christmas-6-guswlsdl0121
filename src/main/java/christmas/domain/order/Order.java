package christmas.domain.order;

import christmas.vo.OrderItem;
import christmas.vo.TotalAmount;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<OrderItem> orderItems;

    private Order() {
        this.orderItems = new ArrayList<>();
    }

    public static Order create() {
        return new Order();
    }

    public void addMenu(OrderItem orderItem) {
        orderItems.add(orderItem);
    }

    public TotalAmount calculateBeforeDiscount() {
        int total = orderItems.stream()
                .mapToInt(OrderItem::calculateTotalPrice)
                .sum();

        return new TotalAmount(total);
    }
}
