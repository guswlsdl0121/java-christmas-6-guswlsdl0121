package christmas.input.validator.date;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import christmas.common.constant.error.ErrorMessage;
import org.junit.jupiter.api.Test;

class DateValidatorTest {

    private final DateValidator validator = new DateValidator();

    @Test
    void testValidateWithValidDate() {
        assertDoesNotThrow(() -> validator.validate("25"));
    }

    @Test
    void testValidateWithEmptyInput() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validate("");
        });
        assertEquals(ErrorMessage.IS_BLANK.getMessage(), exception.getMessage());
    }

    @Test
    void testValidateWithInvalidFormat() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validate("25-12-2023"); // 잘못된 형식
        });
        assertEquals(ErrorMessage.INVALID_DATE.getMessage(), exception.getMessage());
    }
}
