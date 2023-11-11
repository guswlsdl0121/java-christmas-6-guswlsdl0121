package christmas.strategy.discount;

import christmas.constant.event.DiscountType;
import christmas.domain.order.Orders;
import christmas.vo.discount.Discount;
import java.time.LocalDate;
import java.util.Optional;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class DDayDiscountStrategyTest {

    private static Stream<Arguments> provideDatesForDiscounts() {
        return Stream.of(
                Arguments.of(LocalDate.of(2023, 12, 1), 1000), // 12월 1일, 할인 1000원
                Arguments.of(LocalDate.of(2023, 12, 3), 1200), // 12월 3일, 할인 1200원
                Arguments.of(LocalDate.of(2023, 12, 25), 3400), // 12월 25일, 할인 3400원
                Arguments.of(LocalDate.of(2023, 12, 31), 0) // 12월 31일, 할인 없음
        );
    }

    @DisplayName("크리스마스 디데이 할인 적용 테스트")
    @ParameterizedTest(name = "{index}번 케이스:  {1}원")
    @MethodSource("provideDatesForDiscounts")
    void testDDayDiscountStrategy(LocalDate date, int expectedDiscountAmount) {
        //given
        DDayDiscountStrategy strategy = new DDayDiscountStrategy();
        Orders mockOrders = Orders.create();

        //when
        Optional<Discount> result = strategy.calculateDiscount(mockOrders, date);

        //then
        if (expectedDiscountAmount > 0) {
            Assertions.assertTrue(result.isPresent());
            Assertions.assertEquals(DiscountType.D_DAY_DISCOUNT, result.get().discountType());
            Assertions.assertEquals(expectedDiscountAmount, result.get().discountAmount().amount());
        } else {
            Assertions.assertTrue(result.isEmpty());
        }
    }
}
