package christmas.controller;

import christmas.domain.order.Orders;
import christmas.view.output.OutputView;
import christmas.vo.order.OrderItem;
import christmas.vo.order.TotalAmount;
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

    public TotalAmount calculateTotalBeforeDiscount() {
        return orders.calculateTotalAmountBeforeDiscount();
    }
}
