package christmas.domain.order;

import christmas.vo.order.OrderItem;
import christmas.vo.order.TotalAmount;
import java.util.ArrayList;
import java.util.List;

public class Orders {
    private final List<OrderItem> orderItems;

    private Orders() {
        this.orderItems = new ArrayList<>();
    }

    public static Orders create() {
        return new Orders();
    }

    public void addMenu(OrderItem orderItem) {
        orderItems.add(orderItem);
    }

    public TotalAmount calculateTotalAmountBeforeDiscount() {
        int total = orderItems.stream()
                .mapToInt(OrderItem::calculateTotalPrice)
                .sum();

        return new TotalAmount(total);
    }
}
