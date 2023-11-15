package christmas.common.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import christmas.common.constant.error.ErrorMessage;
import org.junit.jupiter.api.Test;

class ParserWrapperTest {

    @Test
    void testParseQuantityWithValidNumber() {
        assertEquals(5, ParserWrapper.parseQuantity("5"));
        assertEquals(123, ParserWrapper.parseQuantity("123"));
    }

    @Test
    void testParseQuantityWithInvalidNumber() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ParserWrapper.parseQuantity("abc");
        });
        assertEquals(ErrorMessage.INVALID_MENU.getMessage(), exception.getMessage());
    }
}
