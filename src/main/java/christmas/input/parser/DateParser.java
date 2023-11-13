package christmas.input.parser;

import christmas.common.constant.error.ErrorMessage;
import christmas.input.result.DateParseResult;
import christmas.input.validator.InputValidator;

public class DateParser implements InputParser<DateParseResult> {
    private final InputValidator<String> inputValidator;

    public DateParser(InputValidator<String> inputValidator) {
        this.inputValidator = inputValidator;
    }

    @Override
    public DateParseResult parse(String input) {
        inputValidator.validate(input);
        int day = parseIntDay(input);
        return new DateParseResult(day);
    }

    private int parseIntDay(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DATE.getMessage());
        }
    }
}

