package christmas.strategy.discount;

import christmas.constant.event.DiscountConfig;
import christmas.constant.event.DiscountType;
import christmas.domain.order.Orders;
import christmas.util.DateUtils;
import christmas.vo.discount.Discount;
import christmas.vo.discount.DiscountAmount;
import java.time.LocalDate;
import java.util.Optional;

public class WeekendDiscountStrategy implements DiscountStrategy {
    private static final int NO_DISCOUNT = 0;

    @Override
    public Optional<Discount> calculateDiscount(Orders orders, LocalDate date) {
        return Optional.of(date)
                .filter(DateUtils::isWeekend)
                .map(discountDate -> calculateDiscountAmount(orders))
                .filter(totalDiscount -> totalDiscount > NO_DISCOUNT)
                .map(this::createDiscount);
    }

    private int calculateDiscountAmount(Orders orders) {
        return orders.calculateMainDiscount(DiscountConfig.DISCOUNT_PER_ITEM.getValue());
    }

    private Discount createDiscount(int discountAmount) {
        return new Discount(DiscountType.WEEKEND_DISCOUNT, new DiscountAmount(discountAmount));
    }
}
