package christmas.factory;

import christmas.strategy.discount.DiscountStrategy;
import christmas.strategy.discount.period.DDayDiscountStrategy;
import christmas.strategy.discount.period.SpecialDiscountStrategy;
import christmas.strategy.discount.regular.WeekdayDiscountStrategy;
import christmas.strategy.discount.regular.WeekendDiscountStrategy;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class DiscountStrategyFactory {
    private final Set<DiscountStrategy> strategies = new HashSet<>();

    public DiscountStrategyFactory(LocalDate date) {
        strategies.add(new WeekdayDiscountStrategy());
        strategies.add(new WeekendDiscountStrategy());
        strategies.add(new DDayDiscountStrategy(date));
        strategies.add(new SpecialDiscountStrategy(date));
    }

    public Set<DiscountStrategy> getStrategiesForDate(LocalDate date) {
        return strategies.stream()
                .filter(strategy -> strategy.isApplicable(date))
                .collect(Collectors.toSet());
    }
}
