package christmas.domain.strategy.discount;

import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.common.constant.event.DiscountType;
import christmas.domain.strategy.discount.WeekendDiscountStrategy;
import christmas.domain.Menu;
import christmas.domain.Orders;
import christmas.vo.discount.Discount;
import christmas.vo.discount.DiscountAmount;
import christmas.vo.order.MenuQuantity;
import christmas.vo.order.OrderItem;
import java.time.LocalDate;
import java.util.Optional;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WeekendDiscountStrategyTest {

    private static Stream<Arguments> provideTestCasesForWeekendDiscount() {
        return Stream.of(
                // 메인 메뉴가 없는 경우 주말 할인 적용되지 않음
                Arguments.of(
                        createOrdersWithoutMainDishes(),
                        LocalDate.of(2023, 12, 2), // 주말
                        Optional.empty()
                ),
                // 메인 메뉴가 있는 경우 주말 할인 적용
                Arguments.of(
                        createOrdersWithMainDishes(1),
                        LocalDate.of(2023, 12, 2), // 주말
                        Optional.of(new Discount(DiscountType.WEEKEND_DISCOUNT, new DiscountAmount(2023)))
                ),
                // 여러 메인 메뉴가 있는 경우 주말 할인 적용
                Arguments.of(
                        createOrdersWithMainDishes(2),
                        LocalDate.of(2023, 12, 2), // 주말
                        Optional.of(new Discount(DiscountType.WEEKEND_DISCOUNT, new DiscountAmount(4046)))
                ),
                // 평일에는 주말 할인 적용되지 않음
                Arguments.of(
                        createOrdersWithMainDishes(1),
                        LocalDate.of(2023, 12, 3), // 평일
                        Optional.empty()
                )
        );
    }

    @DisplayName("주말 할인 적용 여부 확인")
    private static Orders createOrdersWithoutMainDishes() {
        Orders orders = new Orders();
        orders.addMenu(new OrderItem(Menu.CHOCO_CAKE, new MenuQuantity(1)));
        return orders;
    }

    private static Orders createOrdersWithMainDishes(int mainDishCount) {
        Orders orders = new Orders();
        orders.addMenu(new OrderItem(Menu.T_BONE_STEAK, new MenuQuantity(mainDishCount)));
        return orders;
    }

    @ParameterizedTest
    @MethodSource("provideTestCasesForWeekendDiscount")
    void testCalculateDiscount(Orders orders, LocalDate date, Optional<Discount> expectedDiscount) {
        WeekendDiscountStrategy strategy = new WeekendDiscountStrategy();
        Optional<Discount> actualDiscount = strategy.evaluateDiscount(orders, date);
        assertEquals(expectedDiscount, actualDiscount);
    }
}
