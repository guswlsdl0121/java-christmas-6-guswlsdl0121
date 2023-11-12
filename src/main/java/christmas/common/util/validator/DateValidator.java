package christmas.common.util.validator;

import christmas.common.constant.message.ErrorMessage;

public class DateValidator {
    public static int validate(String input) {
        validateNotBlank(input);
        return validateIsValidNumber(input);
    }

    private static void validateNotBlank(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.IS_BLANK.getMessage());
        }
    }

    private static int  validateIsValidNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
        }
    }
}
