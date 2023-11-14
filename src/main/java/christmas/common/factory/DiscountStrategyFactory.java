package christmas.common.factory;

import christmas.domain.strategy.discount.DDayDiscountStrategy;
import christmas.domain.strategy.discount.DiscountStrategy;
import christmas.domain.strategy.discount.SpecialDiscountStrategy;
import christmas.domain.strategy.discount.WeekdayDiscountStrategy;
import christmas.domain.strategy.discount.WeekendDiscountStrategy;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class DiscountStrategyFactory {
    private final Set<DiscountStrategy> strategies;

    public DiscountStrategyFactory() {
        strategies = initializeStrategies();
    }

    private Set<DiscountStrategy> initializeStrategies() {
        Set<DiscountStrategy> initializedStrategies = new HashSet<>();
        initializedStrategies.add(new WeekdayDiscountStrategy());
        initializedStrategies.add(new WeekendDiscountStrategy());
        initializedStrategies.add(new DDayDiscountStrategy());
        initializedStrategies.add(new SpecialDiscountStrategy());
        return initializedStrategies;
    }

    public Set<DiscountStrategy> getStrategiesForDate(LocalDate date) {
        return strategies.stream()
                .filter(strategy -> strategy.isApplicable(date))
                .collect(Collectors.toSet());
    }
}
