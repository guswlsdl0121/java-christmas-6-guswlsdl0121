package christmas.strategy.discount.regular;

import christmas.constant.event.DiscountType;
import christmas.domain.order.Orders;
import christmas.strategy.discount.DiscountStrategy;
import christmas.vo.discount.Discount;
import christmas.vo.discount.DiscountAmount;
import java.util.Optional;

public abstract class RegularDiscountStrategy implements DiscountStrategy {
    private static final int NO_DISCOUNT = 0;

    @Override
    public Optional<Discount> evaluateDiscount(Orders orders) {
        return Optional.of(calculateDiscount(orders))
                .filter(amount -> amount > NO_DISCOUNT)
                .map(amount -> new Discount(getDiscountType(), new DiscountAmount(amount)));
    }

    protected abstract int calculateDiscount(Orders orders);

    protected abstract DiscountType getDiscountType();
}
