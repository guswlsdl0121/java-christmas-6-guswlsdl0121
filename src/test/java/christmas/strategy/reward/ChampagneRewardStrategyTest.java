package christmas.strategy.reward;

import christmas.domain.menu.Menu;
import christmas.vo.order.MenuQuantity;
import christmas.vo.order.OrderItem;
import christmas.vo.order.TotalAmount;
import java.util.Optional;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ChampagneRewardStrategyTest {
    private static Stream<Arguments> provideTotalAmountsForRewards() {
        return Stream.of(
                Arguments.of(119999, Optional.empty()), // 보상을 받을 수 없는 경우
                Arguments.of(120000, Optional.of(new OrderItem(Menu.CHAMPAGNE, new MenuQuantity(1)))),
                // 정확히 보상을 받을 수 있는 최소 금액
                Arguments.of(240000, Optional.of(new OrderItem(Menu.CHAMPAGNE, new MenuQuantity(2)))),
                // 2개의 보상을 받을 수 있는 경우
                Arguments.of(1100000, Optional.of(new OrderItem(Menu.CHAMPAGNE, new MenuQuantity(9))))
                // 최대 보상을 받을 수 있는 경우
        );
    }

    @ParameterizedTest
    @MethodSource("provideTotalAmountsForRewards")
    public void testDetermineReward(int totalAmountValue, Optional<OrderItem> expectedReward) {
        ChampagneRewardStrategy strategy = new ChampagneRewardStrategy();
        TotalAmount totalAmount = new TotalAmount(totalAmountValue);

        Optional<OrderItem> actualReward = strategy.determineReword(totalAmount);

        if (expectedReward.isPresent()) {
            Assertions.assertTrue(actualReward.isPresent());
            Assertions.assertEquals(expectedReward.get(), actualReward.get());
            Assertions.assertEquals(expectedReward.get(), actualReward.get());
        } else {
            Assertions.assertFalse(actualReward.isPresent());
        }
    }
}
