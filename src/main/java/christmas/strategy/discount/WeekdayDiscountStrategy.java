package christmas.strategy.discount;

import christmas.constant.event.DiscountConfig;
import christmas.constant.event.DiscountType;
import christmas.domain.order.Orders;
import christmas.util.DateUtils;
import java.time.LocalDate;

public class WeekdayDiscountStrategy extends AbstractDiscountStrategy {

    @Override
    protected int calculateDiscount(Orders orders) {
        return orders.calculateDessertDiscount(DiscountConfig.DISCOUNT_PER_ITEM.getValue());
    }

    @Override
    protected DiscountType getDiscountType() {
        return DiscountType.WEEKDAY_DISCOUNT;
    }

    @Override
    public boolean isApplicable(LocalDate date) {
        return DateUtils.isWeekday(date);
    }
}
