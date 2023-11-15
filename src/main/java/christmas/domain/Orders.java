package christmas.domain;

import christmas.vo.order.OrderItem;
import christmas.vo.order.TotalAmount;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Orders {
    private final List<OrderItem> orderItems;

    public Orders() {
        this.orderItems = new ArrayList<>();
    }

    public void addOrderItems(List<OrderItem> orderItems) {
        this.orderItems.addAll(orderItems);
    }

    public void addMenu(OrderItem orderItem) {
        orderItems.add(orderItem);
    }

    public TotalAmount calculateTotalAmount() {
        int total = orderItems.stream()
                .mapToInt(OrderItem::calculateTotalPrice)
                .sum();

        return new TotalAmount(total);
    }

    public int calculateDessertDiscount(int discountPerItem) {
        return calculateDiscountFor(OrderItem::isDessert, discountPerItem);
    }

    public int calculateMainDiscount(int discountPerItem) {
        return calculateDiscountFor(OrderItem::isMain, discountPerItem);
    }

    private int calculateDiscountFor(Predicate<OrderItem> filterCondition, int discountPerItem) {
        return orderItems.stream()
                .filter(filterCondition)
                .mapToInt(item -> item.calculateDiscount(discountPerItem))
                .sum();
    }
}
