package christmas.strategy.discount.period;

import christmas.constant.event.DiscountConfig;
import christmas.constant.event.DiscountType;
import christmas.domain.order.Orders;
import christmas.util.DateUtils;
import java.time.LocalDate;

public class SpecialDiscountStrategy extends PeriodicDiscountStrategy {
    private static final int SPECIAL_DISCOUNT_AMOUNT = DiscountConfig.SPECIAL_DISCOUNT_AMOUNT.getValue();

    public SpecialDiscountStrategy(LocalDate discountDate) {
        super(discountDate);
    }

    @Override
    protected int calculateDiscount(Orders orders, LocalDate date) {
        return SPECIAL_DISCOUNT_AMOUNT;
    }

    @Override
    protected DiscountType getDiscountType() {
        return DiscountType.SPECIAL_DISCOUNT;
    }

    @Override
    public boolean isApplicable(LocalDate date) {
        return DateUtils.isSpecial(date);
    }
}

