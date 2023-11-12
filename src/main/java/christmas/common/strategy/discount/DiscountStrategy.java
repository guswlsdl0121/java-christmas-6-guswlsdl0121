package christmas.common.strategy.discount;

import christmas.domain.order.Orders;
import christmas.vo.discount.Discount;
import java.time.LocalDate;
import java.util.Optional;

public interface DiscountStrategy {
    Optional<Discount> evaluateDiscount(Orders orders, LocalDate date);

    boolean isApplicable(LocalDate date);
}

