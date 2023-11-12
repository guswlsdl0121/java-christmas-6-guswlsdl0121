package christmas.common.validator;

import christmas.common.constant.error.ErrorMessage;

public class CommonValidator {
    public static void validateNotBlank(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.IS_BLANK.getMessage());
        }
    }
}
