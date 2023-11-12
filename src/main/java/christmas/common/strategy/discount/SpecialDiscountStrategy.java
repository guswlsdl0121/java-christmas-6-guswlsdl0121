package christmas.common.strategy.discount;

import christmas.common.constant.event.DiscountConfig;
import christmas.common.constant.event.DiscountType;
import christmas.common.util.DateUtils;
import christmas.domain.order.Orders;
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


