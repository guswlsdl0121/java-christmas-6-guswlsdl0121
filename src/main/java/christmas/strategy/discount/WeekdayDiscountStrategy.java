package christmas.strategy.discount;

import christmas.constant.event.DiscountConfig;
import christmas.constant.event.DiscountType;
import christmas.domain.order.Orders;
import christmas.util.DateUtils;
import christmas.vo.discount.Discount;
import christmas.vo.discount.DiscountAmount;
import java.time.LocalDate;
import java.util.Optional;

public class WeekdayDiscountStrategy implements DiscountStrategy {

    private static final int NO_DISCOUNT = 0;

    @Override
    public Optional<Discount> calculateDiscount(Orders orders, LocalDate date) {
        return Optional.of(date)
                .filter(DateUtils::isWeekday)
                .map(discountDate -> calculateDiscountAmount(orders))
                .filter(totalDiscount -> totalDiscount > NO_DISCOUNT)
                .map(this::createDiscount);
    }

    private static int calculateDiscountAmount(Orders orders) {
        return orders.calculateDessertDiscount(DiscountConfig.WEEKDAY_DISCOUNT_PER_ITEM.getValue());
    }

    private Discount createDiscount(int discountAmount) {
        return new Discount(DiscountType.WEEKDAY_DISCOUNT, new DiscountAmount(discountAmount));
    }
}
