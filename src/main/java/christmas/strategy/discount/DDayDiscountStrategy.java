package christmas.strategy.discount;

import christmas.constant.event.DiscountConfig;
import christmas.constant.event.DiscountType;
import christmas.domain.order.Orders;
import christmas.util.DateUtils;
import christmas.vo.discount.Discount;
import christmas.vo.discount.DiscountAmount;
import java.time.LocalDate;
import java.util.Optional;

public class DDayDiscountStrategy implements DiscountStrategy {

    private static final int FIRST_DAY_OF_MONTH = 1;

    @Override
    public Optional<Discount> calculateDiscount(Orders orders, LocalDate date) {
        return Optional.of(date)
                .filter(DateUtils::isEligibleForDDayDiscount)
                .map(this::calculateDiscountAmount)
                .map(this::createDiscount);
    }

    private int calculateDiscountAmount(LocalDate date) {
        int startAmount = DiscountConfig.DISCOUNT_START_AMOUNT.getValue();
        int increment = DiscountConfig.DISCOUNT_INCREMENT.getValue();
        int dayOfMonth = date.getDayOfMonth();

        return startAmount + increment * (dayOfMonth - FIRST_DAY_OF_MONTH);
    }

    private Discount createDiscount(int discountAmount) {
        return new Discount(DiscountType.D_DAY_DISCOUNT, new DiscountAmount(discountAmount));
    }
}
