package christmas.strategy.discount;

import christmas.constant.event.DiscountConfig;
import christmas.constant.event.DiscountType;
import christmas.domain.order.Orders;
import christmas.util.DateUtils;
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
        return DateUtils.isWeekend(date);
    }
}
