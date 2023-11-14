package christmas.domain.strategy.discount;

import christmas.domain.Orders;
import christmas.vo.discount.Discount;
import java.time.LocalDate;
import java.util.Optional;

public interface DiscountStrategy {
    Optional<Discount> evaluateDiscount(Orders orders, LocalDate date);

    boolean isApplicable(LocalDate date);
}

