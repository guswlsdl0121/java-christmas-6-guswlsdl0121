package christmas.domain.strategy.discount;

import christmas.common.constant.event.DiscountType;
import christmas.domain.Orders;
import christmas.vo.discount.Discount;
import christmas.vo.discount.DiscountAmount;
import java.time.LocalDate;
import java.util.Optional;

public abstract class AbstractDiscountStrategy implements DiscountStrategy {

    private static final Integer NO_DISCOUNT = 0;

    @Override
    public Optional<Discount> evaluateDiscount(Orders orders, LocalDate date) {
        return Optional.of(date)
                .filter(this::isApplicable)
                .map(currentDate -> calculateDiscount(orders))
                .filter(amount -> amount > NO_DISCOUNT)
                .map(this::createDiscount);
    }

    protected abstract int calculateDiscount(Orders orders);

    protected abstract DiscountType getDiscountType();

    private Discount createDiscount(int discountAmount) {
        return new Discount(getDiscountType(), new DiscountAmount(discountAmount));
    }
}
