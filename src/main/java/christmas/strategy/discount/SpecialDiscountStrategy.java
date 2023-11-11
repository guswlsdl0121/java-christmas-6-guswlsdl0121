package christmas.strategy.discount;

import christmas.constant.event.DiscountConfig;
import christmas.constant.event.DiscountType;
import christmas.domain.order.Orders;
import christmas.util.DateUtils;
import christmas.vo.discount.Discount;
import christmas.vo.discount.DiscountAmount;
import java.time.LocalDate;
import java.util.Optional;

public class SpecialDiscountStrategy implements DiscountStrategy{
    private static final int SPECIAL_DISCOUNT_AMOUNT = DiscountConfig.SPECIAL_DISCOUNT_AMOUNT.getValue();

    @Override
    public Optional<Discount> calculateDiscount(Orders orders, LocalDate date) {
        return Optional.of(date)
                .filter(d -> DateUtils.isSunday(d) || DateUtils.isChristmasDay(d))
                .map(discountDate -> createDiscount());
    }

    private Discount createDiscount() {
        return new Discount(DiscountType.SPECIAL_DISCOUNT, new DiscountAmount(
                SpecialDiscountStrategy.SPECIAL_DISCOUNT_AMOUNT));
    }
}
