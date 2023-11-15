package christmas.domain;

import christmas.vo.order.MenuQuantity;
import christmas.vo.order.OrderItem;
import christmas.vo.order.TotalAmount;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

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
        Orders orders = new Orders();
        for (OrderItem item : orderItems) {
            orders.addMenu(item);
        }

        int actualTotalPrice = orders.calculateTotalAmount().amount();

        Assertions.assertEquals(expectedTotalPrice, actualTotalPrice);
    }

    @Test
    @DisplayName("디저트 할인 계산 테스트")
    public void testCalculateDessertDiscount() {
        Orders orders = new Orders();
        orders.addMenu(new OrderItem(Menu.CHOCO_CAKE, new MenuQuantity(3))); // 예: 할인액 * 3
        int discount = orders.calculateDessertDiscount(2023); // 예: 500원 할인

        Assertions.assertEquals(6069, discount); // 예상 할인액: 500 * 3
    }

    @Test
    @DisplayName("메인 요리 할인 계산 테스트")
    public void testCalculateMainDiscount() {
        Orders orders = new Orders();
        orders.addMenu(new OrderItem(Menu.T_BONE_STEAK, new MenuQuantity(2))); // 예: 할인액 * 2
        int discount = orders.calculateMainDiscount(2023); // 예: 1000원 할인

        Assertions.assertEquals(4046, discount); // 예상 할인액: 1000 * 2
    }

    @Test
    @DisplayName("주문 일괄 추가 테스트")
    void testAddOrderItems() {
        Orders orders = new Orders();
        List<OrderItem> items = List.of(new OrderItem(Menu.T_BONE_STEAK, new MenuQuantity(5)),
                new OrderItem(Menu.CHOCO_CAKE, new MenuQuantity(4)));
        orders.addOrderItems(items);

        int expectedTotalPrice = (55000 * 5) + (15000 * 4);
        TotalAmount totalAmount = orders.calculateTotalAmount();

        Assertions.assertEquals(expectedTotalPrice, totalAmount.amount());
    }
}
