package christmas.controller;

import christmas.domain.order.Orders;
import christmas.vo.order.TotalAmount;
import christmas.vo.order.TotalOrder;

public class OrderController {
    private final Orders orders;

    public OrderController(TotalOrder totalOrder) {
        this.orders = Orders.fromOrderItems(totalOrder.orderItems());
    }

    public Orders getOrders() {
        return this.orders;
    }

    public TotalAmount calculateTotalBeforeDiscount() {
        return orders.calculateTotalAmountBeforeDiscount();
    }
}
