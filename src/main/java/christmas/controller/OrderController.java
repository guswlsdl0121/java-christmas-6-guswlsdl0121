package christmas.controller;

import christmas.domain.order.Orders;
import christmas.view.OutputView;
import christmas.vo.order.OrderItem;
import christmas.vo.order.TotalAmount;
import christmas.vo.order.TotalOrder;
import java.util.List;

public class OrderController {
    private final Orders orders;

    public OrderController() {
        this.orders = new Orders();
    }

    public Orders proceedOrder(TotalOrder totalOrder) {
        List<OrderItem> orderItems = totalOrder.orderItems();
        orders.addOrderItems(orderItems);
        return orders;
    }

    public TotalAmount calculateTotalBeforeDiscount() {
        TotalAmount totalBeforeDiscount = orders.calculateTotalAmountBeforeDiscount();
        OutputView.printBeforeDiscount(totalBeforeDiscount);
        return totalBeforeDiscount;
    }
}
