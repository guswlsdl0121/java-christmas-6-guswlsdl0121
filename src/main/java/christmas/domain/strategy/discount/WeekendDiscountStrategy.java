package christmas.domain.strategy.discount;

import christmas.common.constant.event.DiscountConfig;
import christmas.common.constant.event.DiscountType;
import christmas.common.util.DateUtil;
import christmas.domain.Orders;
import java.time.LocalDate;

public class WeekendDiscountStrategy extends AbstractDiscountStrategy {

    @Override
    protected int calculateDiscount(Orders orders) {
        return orders.calculateMainDiscount(DiscountConfig.DISCOUNT_PER_ITEM.getValue());
    }

    @Override
    protected DiscountType getDiscountType() {
        return DiscountType.WEEKEND_DISCOUNT;
    }

    @Override
    public boolean isApplicable(LocalDate date) {
        return DateUtil.isWeekend(date);
    }
}
