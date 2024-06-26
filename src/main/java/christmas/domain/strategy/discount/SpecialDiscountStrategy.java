package christmas.domain.strategy.discount;

import christmas.common.constant.event.DiscountConfig;
import christmas.common.constant.event.DiscountType;
import christmas.common.util.DateUtil;
import christmas.domain.Orders;
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
        return DateUtil.isSpecial(date);
    }
}


