package christmas.input.validator.date;

import christmas.common.constant.error.ErrorMessage;
import christmas.common.constant.view.InputFormat;
import christmas.input.validator.InputValidator;
import java.util.regex.Pattern;

public class DateValidator implements InputValidator<String> {
    private static final Pattern DAY_PATTERN = InputFormat.DAY_PATTERN.getPattern();

    @Override
    public void validate(String input) {
        validateNotEmpty(input);
        validateFormat(input);
    }

    private void validateNotEmpty(String input) {
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.IS_BLANK.getMessage());
        }
    }

    private void validateFormat(String input) {
        if (!DAY_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DATE.getMessage());
        }
    }
}
