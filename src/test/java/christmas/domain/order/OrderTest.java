package christmas.domain.order;

import christmas.domain.menu.Menu;
import christmas.vo.MenuQuantity;
import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Stream;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class OrderTest {

    private static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of(
                        new EnumMap<>(Map.of(
                                Menu.MUSHROOM_SOUP, MenuQuantity.from(2),   // 예: 6000 * 2
                                Menu.T_BONE_STEAK, MenuQuantity.from(1)    // 예: 55000 * 1
                        )),
                        67000
                ),
                Arguments.of(
                        new EnumMap<>(Map.of(
                                Menu.T_BONE_STEAK, MenuQuantity.from(20)   // 예: 55000 * 1
                        )),
                        1100000
                )
        );
    }

    @ParameterizedTest(name = "{index}번 케이스:  {1}원")
    @MethodSource("dataProvider")
    @DisplayName("할인 전 총 주문 금액 계산 테스트")
    public void testCalculateTotalPrice(@NotNull EnumMap<Menu, MenuQuantity> menuOrders, int expectedTotalPrice) {
        Order order = Order.create();
        menuOrders.forEach(order::addMenu);

        int actualTotalPrice = order.calculateTotalPrice();

        Assertions.assertEquals(expectedTotalPrice, actualTotalPrice, "Calculated total price should match expected price.");
    }
}
