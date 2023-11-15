package christmas.input.validator.order;

import christmas.common.constant.error.ErrorMessage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OrderFormatValidatorTest {

    private final OrderFormatValidator validator = new OrderFormatValidator();

    @Test
    void testValidateWithValidInput() {
        assertDoesNotThrow(() -> validator.validate("음식-3,음료-1"));
    }

    @Test
    void testValidateWithEmptyInput() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validate("");
        });
        assertEquals(ErrorMessage.IS_BLANK.getMessage(), exception.getMessage());
    }

    @Test
    void testValidateWithNullInput() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validate(null);
        });
        assertEquals(ErrorMessage.IS_BLANK.getMessage(), exception.getMessage());
    }

    @Test
    void testValidateWithInvalidFormat() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validate("음식,음료-1"); // 잘못된 형식
        });
        assertEquals(ErrorMessage.INVALID_MENU.getMessage(), exception.getMessage());
    }
}
