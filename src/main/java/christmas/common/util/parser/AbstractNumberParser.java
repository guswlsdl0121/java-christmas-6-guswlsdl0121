package christmas.common.util.parser;

import christmas.common.constant.message.ErrorMessage;

public abstract class AbstractNumberParser<T> implements InputParser<T> {

    protected void validateInParsing(String input) {
        validateIsBlank(input);
    }

    protected abstract T convert(String input);

    private void validateIsBlank(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.IS_BLANK.getMessage());
        }
    }
}
