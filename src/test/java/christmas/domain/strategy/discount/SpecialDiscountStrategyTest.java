package christmas.domain.strategy.discount;

import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.common.constant.event.DiscountType;
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

class SpecialDiscountStrategyTest {

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                // 일요일에 특별 할인 적용
                Arguments.of(
                        createOrdersWithItems(),
                        LocalDate.of(2023, 12, 3), // 일요일
                        Optional.of(new Discount(DiscountType.SPECIAL_DISCOUNT, new DiscountAmount(1000)))
                ),
                // 크리스마스 당일에 특별 할인 적용
                Arguments.of(
                        createOrdersWithItems(),
                        LocalDate.of(2023, 12, 25), // 크리스마스
                        Optional.of(new Discount(DiscountType.SPECIAL_DISCOUNT, new DiscountAmount(1000)))
                ),
                // 평일에는 특별 할인 적용되지 않음
                Arguments.of(
                        createOrdersWithItems(),
                        LocalDate.of(2023, 12, 1), // 평일
                        Optional.empty()
                )
        );
    }

    private static Orders createOrdersWithItems() {
        Orders orders = new Orders();
        orders.addMenu(new OrderItem(Menu.CHOCO_CAKE, new MenuQuantity(5)));
        return orders;
    }

    @DisplayName("특별할인 적용 여부 확인")
    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testCalculateDiscount(Orders orders, LocalDate date, Optional<Discount> expectedDiscount) {
        SpecialDiscountStrategy strategy = new SpecialDiscountStrategy();
        Optional<Discount> actualDiscount = strategy.evaluateDiscount(orders, date);
        assertEquals(expectedDiscount, actualDiscount);
    }
}
