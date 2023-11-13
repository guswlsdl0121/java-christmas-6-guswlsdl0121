package christmas.input.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import christmas.common.constant.error.ErrorMessage;
import christmas.input.creator.OrderCreator;
import christmas.input.result.OrderParseResult;
import christmas.input.validator.order.OrderFormatValidator;
import christmas.input.validator.order.OrderItemValidator;
import christmas.vo.order.OrderItem;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class OrderParserTest {
    private final OrderParser parser = new OrderParser(new OrderFormatValidator());
    private final OrderCreator creator = new OrderCreator(new OrderItemValidator());

    private static Stream<Arguments> provideValidInputs() {
        return Stream.of(
                Arguments.of("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1", 4),
                Arguments.of("티본스테이크-2,크리스마스파스타-1", 2),
                Arguments.of("시저샐러드-1,레드와인-1,양송이수프-1", 3),
                Arguments.of("타파스-1", 1),
                Arguments.of("초코케이크-1,제로콜라-2", 2)
        );
    }

    private static Stream<Arguments> provideInvalidInputs() {
        return Stream.of(
                Arguments.of("없는메뉴-1", ErrorMessage.INVALID_MENU.getMessage()),
                Arguments.of("티본스테이크-", ErrorMessage.INVALID_MENU.getMessage()),
                Arguments.of("초코케이크-10,제로콜라-11", ErrorMessage.ORDER_QUANTITY_EXCEEDED.getMessage()),
                Arguments.of("제로콜라-3,레드와인-4", ErrorMessage.BEVERAGES_ONLY_ORDER.getMessage()),
                Arguments.of("티본스테이크-1,없는메뉴-2", ErrorMessage.INVALID_MENU.getMessage()),
                Arguments.of("바비큐립-0", ErrorMessage.INVALID_MENU.getMessage()),
                Arguments.of("티본스테이크-1,바비큐립-1,티본스테이크-1", ErrorMessage.INVALID_MENU.getMessage())
        );
    }

    @ParameterizedTest
    @MethodSource("provideValidInputs")
    @DisplayName("주문 파싱 - 유효한 입력")
    void testValidOrderParsing(String input, int expectedItemCount) {
        OrderParseResult parseResult = parser.parse(input);
        assertNotNull(parseResult);
        List<OrderItem> createdOrderItems = creator.create(parseResult);
        assertEquals(expectedItemCount, createdOrderItems.size());
    }

    @ParameterizedTest
    @MethodSource("provideInvalidInputs")
    @DisplayName("주문 파싱 - 유효하지 않은 입력")
    void testInvalidOrderParsing(String input, String expectedErrorMessage) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            OrderParseResult parseResult = parser.parse(input);
            creator.create(parseResult);
        });
        assertEquals(expectedErrorMessage, exception.getMessage());
    }

}
