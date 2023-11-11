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

    public int calculateDessertDiscount(int discountPerItem) {
        return orderItems.stream()
                .filter(OrderItem::isDessert) // Dessert 메뉴인지 확인
                .mapToInt(item -> item.calculateDiscount(discountPerItem))
                .sum();
    }

    public int calculateMainDiscount(int discountPerItem) {
        return orderItems.stream()
                .filter(OrderItem::isMain)
                .mapToInt(item -> item.calculateDiscount(discountPerItem))
                .sum();
    }
}
