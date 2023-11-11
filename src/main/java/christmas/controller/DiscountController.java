package christmas.controller;

import christmas.domain.order.Orders;
import christmas.factory.DiscountStrategyFactory;
import christmas.vo.discount.Discount;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class DiscountController {
    private final DiscountStrategyFactory strategyFactory;

    public DiscountController(DiscountStrategyFactory strategyFactory) {
        this.strategyFactory = strategyFactory;
    }

    public List<Discount> proceedDiscount(Orders orders, LocalDate date) {
        return strategyFactory.getStrategiesForDate(date).stream()
                .map(strategy -> strategy.evaluateDiscount(orders))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
    }
}
