package christmas.common.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import christmas.common.constant.error.ErrorMessage;
import christmas.vo.order.OrderItems;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class OrderInputParserTest {

    private static Stream<Arguments> provideInputForOrderParsing() {
        return Stream.of(
                Arguments.of("티본스테이크-11,바비큐립-1,초코케이크-2,제로콜라-1", true, 4, null),
                Arguments.of("없는메뉴-1", false, 0, ErrorMessage.INVALID_MENU.getMessage()),
                Arguments.of("티본스테이크-0", false, 0, ErrorMessage.INVALID_MENU.getMessage()),
                Arguments.of("티본스테이크,-1", false, 0, ErrorMessage.INVALID_MENU.getMessage()),
                Arguments.of("티본스테이크,1", false, 0, ErrorMessage.INVALID_MENU.getMessage()),
                Arguments.of("티본스테이크-21", false, 0, ErrorMessage.INVALID_MENU.getMessage()),
                Arguments.of("T_BONE_STEAK-21", false, 0, ErrorMessage.INVALID_MENU.getMessage()),
                Arguments.of("시저샐러드-1,시저샐러드-1", false, 0, ErrorMessage.INVALID_MENU.getMessage())
        );
    }

    @ParameterizedTest
    @MethodSource("provideInputForOrderParsing")
    @DisplayName("주문 파싱 테스트")
    void testOrderParsing(String input, boolean isValid, int expectedItemCount, String expectedErrorMessage) {
        OrderInputParser parser = new OrderInputParser();

        if (isValid) {
            OrderItems parsedOrderItems = parser.parse(input);
            assertNotNull(parsedOrderItems);
            assertEquals(expectedItemCount, parsedOrderItems.orderItems().size());
        } else {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                    () -> parser.parse(input));
            assertEquals(expectedErrorMessage, exception.getMessage());
        }
    }
}
