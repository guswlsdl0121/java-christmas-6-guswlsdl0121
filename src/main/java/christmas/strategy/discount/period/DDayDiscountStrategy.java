package christmas.strategy.discount.period;

import christmas.constant.event.DiscountConfig;
import christmas.constant.event.DiscountType;
import christmas.domain.order.Orders;
import christmas.util.DateUtils;
import java.time.LocalDate;

public class DDayDiscountStrategy extends PeriodicDiscountStrategy {

    private static final int FIRST_DAY_OF_MONTH = 1;

    public DDayDiscountStrategy(LocalDate discountDate) {
        super(discountDate);
    }

    @Override
    protected int calculateDiscount(Orders orders, LocalDate date) {
        int startAmount = DiscountConfig.DISCOUNT_START_AMOUNT.getValue();
        int increment = DiscountConfig.DISCOUNT_INCREMENT.getValue();
        int dayOfMonth = date.getDayOfMonth();

        return startAmount + increment * (dayOfMonth - FIRST_DAY_OF_MONTH);
    }

    @Override
    protected DiscountType getDiscountType() {
        return DiscountType.D_DAY_DISCOUNT;
    }

    @Override
    public boolean isApplicable(LocalDate date) {
        return DateUtils.isInDDayEvent(date);
    }
}
