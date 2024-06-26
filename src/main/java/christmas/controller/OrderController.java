package christmas.controller;

import christmas.domain.Orders;
import christmas.vo.order.OrderItem;
import christmas.vo.order.TotalOrder;
import java.util.List;

public class OrderController {
    private final Orders orders;

    public OrderController() {
        this.orders = new Orders();
    }

    public Orders createOrder(TotalOrder totalOrder) {
        List<OrderItem> orderItems = totalOrder.orderItems();
        orders.addOrderItems(orderItems);
        return orders;
    }
}
