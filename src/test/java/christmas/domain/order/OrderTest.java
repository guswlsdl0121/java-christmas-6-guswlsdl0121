package christmas.domain.order;

import christmas.vo.OrderItem;
import christmas.domain.menu.Menu;
import christmas.vo.MenuQuantity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

public class OrderTest {

    private static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of(
                        new OrderItem[]{
                                OrderItem.of(Menu.MUSHROOM_SOUP, MenuQuantity.from(2)), // 예: 6000 * 2
                                OrderItem.of(Menu.T_BONE_STEAK, MenuQuantity.from(1))  // 예: 55000 * 1
                        },
                        67000
                ),
                Arguments.of(
                        new OrderItem[]{
                                OrderItem.of(Menu.T_BONE_STEAK, MenuQuantity.from(20)) // 예: 55000 * 20
                        },
                        1100000
                )
        );
    }

    @ParameterizedTest(name = "{index}번 케이스:  {1}원")
    @MethodSource("dataProvider")
    @DisplayName("할인 전 총 주문 금액 계산 테스트")
    public void testCalculateTotalPrice(OrderItem[] orderItems, int expectedTotalPrice) {
        Order order = Order.create();
        for (OrderItem item : orderItems) {
            order.addMenu(item);
        }

        int actualTotalPrice = order.calculateBeforeDiscount().getAmount();

        Assertions.assertEquals(expectedTotalPrice, actualTotalPrice, "Calculated total price should match expected price.");
    }
}
