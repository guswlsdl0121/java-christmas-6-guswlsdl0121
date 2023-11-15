package christmas.common.factory;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import christmas.domain.strategy.discount.DDayDiscountStrategy;
import christmas.domain.strategy.discount.DiscountStrategy;
import christmas.domain.strategy.discount.SpecialDiscountStrategy;
import christmas.domain.strategy.discount.WeekdayDiscountStrategy;
import christmas.domain.strategy.discount.WeekendDiscountStrategy;
import java.time.LocalDate;
import java.util.Set;
import org.junit.jupiter.api.Test;

class DiscountStrategyFactoryTest {

    private final DiscountStrategyFactory strategyFactory = new DiscountStrategyFactory();

    @Test
    void testGetStrategiesForWeekday() {
        LocalDate weekday = LocalDate.of(2023, 12, 1); // 가정: 이 날짜는 주말
        Set<DiscountStrategy> strategies = strategyFactory.getStrategiesForDate(weekday);

        assertFalse(strategies.stream().anyMatch(strategy -> strategy instanceof WeekdayDiscountStrategy));
        assertTrue(strategies.stream().anyMatch(strategy -> strategy instanceof WeekendDiscountStrategy));
        assertFalse(strategies.stream().anyMatch(strategy -> strategy instanceof SpecialDiscountStrategy));
        assertTrue(strategies.stream().anyMatch(strategy -> strategy instanceof DDayDiscountStrategy));
    }

    @Test
    void testGetStrategiesForWeekend() {
        LocalDate weekend = LocalDate.of(2023, 12, 25); // 가정: 이 날짜는 25일
        Set<DiscountStrategy> strategies = strategyFactory.getStrategiesForDate(weekend);

        assertTrue(strategies.stream().anyMatch(strategy -> strategy instanceof WeekdayDiscountStrategy));
        assertFalse(strategies.stream().anyMatch(strategy -> strategy instanceof WeekendDiscountStrategy));
        assertTrue(strategies.stream().anyMatch(strategy -> strategy instanceof SpecialDiscountStrategy));
        assertTrue(strategies.stream().anyMatch(strategy -> strategy instanceof DDayDiscountStrategy));
    }

    // DDay와 Special 전략에 대한 추가적인 테스트를 여기에 구현할 수 있습니다.
}
