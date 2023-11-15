package christmas.controller;

import christmas.common.constant.order.OrderConstant;
import christmas.common.factory.DiscountStrategyFactory;
import christmas.domain.Orders;
import christmas.vo.discount.Discount;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class DiscountController {
    private final DiscountStrategyFactory strategyFactory;

    public DiscountController(DiscountStrategyFactory strategyFactory) {
        this.strategyFactory = strategyFactory;
    }

    public List<Discount> applyDiscount(Orders orders, LocalDate date) {
        if (!orders.calculateTotalAmount().isEqualOrGreater(OrderConstant.MIN_ORDER_AMOUNT.getValue())) {
            return Collections.emptyList();
        }
        return strategyFactory.getStrategiesForDate(date).stream()
                .map(strategy -> strategy.evaluateDiscount(orders, date))
                .flatMap(Optional::stream)
                .toList();
    }
}

