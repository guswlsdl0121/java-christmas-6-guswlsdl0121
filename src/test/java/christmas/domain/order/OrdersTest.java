package christmas.domain.order;

import christmas.vo.order.OrderItem;
import christmas.domain.menu.Menu;
import christmas.vo.order.MenuQuantity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

public class OrdersTest {

    private static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of(
                        new OrderItem[]{
                                new OrderItem(Menu.MUSHROOM_SOUP, new MenuQuantity(2)), // 예: 6000 * 2
                                new OrderItem(Menu.T_BONE_STEAK, new MenuQuantity(1))  // 예: 55000 * 1
                        },
                        67000
                ),
                Arguments.of(
                        new OrderItem[]{
                                new OrderItem(Menu.T_BONE_STEAK, new MenuQuantity(20)) // 예: 55000 * 20
                        },
                        1100000
                )
        );
    }

    @ParameterizedTest(name = "{index}번 케이스:  {1}원")
    @MethodSource("dataProvider")
    @DisplayName("할인 전 총 주문 금액 계산 테스트")
    public void testCalculateTotalPrice(OrderItem[] orderItems, int expectedTotalPrice) {
        Orders orders = Orders.create();
        for (OrderItem item : orderItems) {
            orders.addMenu(item);
        }

        int actualTotalPrice = orders.calculateTotalAmountBeforeDiscount().amount();

        Assertions.assertEquals(expectedTotalPrice, actualTotalPrice);
    }
}
