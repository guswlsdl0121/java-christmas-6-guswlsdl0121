package christmas.domain.strategy.discount;

import christmas.common.constant.event.DiscountConfig;
import christmas.common.constant.event.DiscountType;
import christmas.common.util.DateUtil;
import christmas.domain.Orders;
import christmas.vo.discount.Discount;
import christmas.vo.discount.DiscountAmount;
import java.time.LocalDate;
import java.util.Optional;

public class DDayDiscountStrategy implements DiscountStrategy {
    private static final int FIRST_DAY_OF_MONTH = 1;

    @Override
    public Optional<Discount> evaluateDiscount(Orders orders, LocalDate date) {
        return Optional.of(date)
                .filter(this::isApplicable)
                .map(this::calculateDiscount)
                .map(this::createDiscount);
    }

    private int calculateDiscount(LocalDate date) {
        int startAmount = DiscountConfig.DISCOUNT_START_AMOUNT.getValue();
        int increment = DiscountConfig.DISCOUNT_INCREMENT.getValue();
        int dayOfMonth = date.getDayOfMonth();

        return startAmount + increment * (dayOfMonth - FIRST_DAY_OF_MONTH);
    }

    private Discount createDiscount(int discountAmount) {
        return new Discount(getDiscountType(), new DiscountAmount(discountAmount));
    }

    private DiscountType getDiscountType() {
        return DiscountType.D_DAY_DISCOUNT;
    }

    @Override
    public boolean isApplicable(LocalDate date) {
        return DateUtil.isInDDayEvent(date);
    }
}
