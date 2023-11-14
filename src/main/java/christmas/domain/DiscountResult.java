package christmas.domain;

import christmas.vo.discount.Discount;
import christmas.vo.order.OrderItem;
import christmas.vo.order.TotalAmount;
import java.util.List;
import java.util.Optional;

public class DiscountResult {
    private final List<Discount> discounts;

    public DiscountResult(List<Discount> discounts) {
        this.discounts = discounts;
    }

    private static final int NOTHING = 0;

    public int calculateTotalBenefit(Optional<OrderItem> reward) {
        int discountSum = calculateDiscountSum();
        int rewardPrice = reward
                .map(OrderItem::calculateTotalPrice)
                .orElse(NOTHING);
        return discountSum + rewardPrice;
    }

    public int calculateDiscountedTotal(TotalAmount totalAmount) {
        int discountSum = calculateDiscountSum();
        return totalAmount.calculateDiscountedAmount(discountSum);
    }

    private int calculateDiscountSum() {
        return discounts.stream()
                .mapToInt(Discount::calculateAmount)
                .sum();
    }
}
