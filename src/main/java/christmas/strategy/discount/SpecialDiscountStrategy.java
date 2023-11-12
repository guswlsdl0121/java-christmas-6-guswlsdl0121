package christmas.strategy.discount;

import christmas.constant.event.DiscountConfig;
import christmas.constant.event.DiscountType;
import christmas.domain.order.Orders;
import christmas.util.DateUtils;
import java.time.LocalDate;


public class SpecialDiscountStrategy extends AbstractDiscountStrategy {
    @Override
    protected int calculateDiscount(Orders orders) {
        return DiscountConfig.SPECIAL_DISCOUNT_AMOUNT.getValue();
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


