package christmas.strategy.discount;

import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.constant.event.DiscountType;
import christmas.domain.menu.Menu;
import christmas.domain.order.Orders;
import christmas.strategy.discount.regular.WeekdayDiscountStrategy;
import christmas.vo.discount.Discount;
import christmas.vo.discount.DiscountAmount;
import christmas.vo.order.MenuQuantity;
import christmas.vo.order.OrderItem;
import java.time.LocalDate;
import java.util.Optional;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WeekdayDiscountStrategyTest {

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                // 디저트가 없는 경우 할인이 적용되지 않아야 함
                Arguments.of(createOrdersWithoutDesserts(), LocalDate.of(2023, 12, 3), Optional.empty()),
                // 디저트가 있는 경우 할인 적용
                Arguments.of(createOrdersWithDesserts(1), LocalDate.of(2023, 12, 3),
                        Optional.of(new Discount(DiscountType.WEEKDAY_DISCOUNT, new DiscountAmount(2023)))),
                // 여러 디저트가 있는 경우 할인 적용
                Arguments.of(createOrdersWithDesserts(2), LocalDate.of(2023, 12, 3),
                        Optional.of(new Discount(DiscountType.WEEKDAY_DISCOUNT, new DiscountAmount(4046)))),
                // 주말에는 할인 적용되지 않음
                Arguments.of(createOrdersWithDesserts(1), LocalDate.of(2023, 12, 1), Optional.empty())
        );
    }

    private static Orders createOrdersWithoutDesserts() {
        Orders orders = Orders.create();
        orders.addMenu(new OrderItem(Menu.T_BONE_STEAK, new MenuQuantity(1)));
        return orders;
    }

    private static Orders createOrdersWithDesserts(int dessertCount) {
        Orders orders = Orders.create();
        orders.addMenu(new OrderItem(Menu.CHOCO_CAKE, new MenuQuantity(dessertCount)));
        return orders;
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testCalculateDiscount(Orders orders, LocalDate date, Optional<Discount> expectedDiscount) {
        WeekdayDiscountStrategy strategy = new WeekdayDiscountStrategy();

        if (strategy.isApplicable(date)) {
            Optional<Discount> actualDiscount = strategy.evaluateDiscount(orders);
            assertEquals(expectedDiscount, actualDiscount);
        } else {
            assertEquals(expectedDiscount, Optional.empty());
        }
    }
}
