package christmas.input.validator.order;

import christmas.common.constant.error.ErrorMessage;
import christmas.common.constant.view.InputConstant;
import christmas.common.constant.view.InputFormat;
import christmas.input.validator.InputValidator;
import java.util.Arrays;
import java.util.regex.Pattern;

public class OrderFormatValidator implements InputValidator<String> {
    private static final Pattern ITEM_FORMAT_PATTERN = InputFormat.ITEM_FORMAT_PATTERN.getPattern();

    @Override
    public void validate(String input) {
        validateNotEmpty(input);
        validateItemFormat(input);
    }

    private void validateNotEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.IS_BLANK.getMessage());
        }
    }

    private void validateItemFormat(String input) {
        Arrays.stream(input.split(InputConstant.ITEM_SEPARATOR.getValue()))
                .forEach(this::checkFormat);
    }

    private void checkFormat(String item) {
        if (!ITEM_FORMAT_PATTERN.matcher(item).matches()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MENU.getMessage());
        }
    }
}
