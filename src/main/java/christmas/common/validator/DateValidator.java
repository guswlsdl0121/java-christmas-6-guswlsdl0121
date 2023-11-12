package christmas.common.validator;

import christmas.common.util.ParserWrapper;

public class DateValidator {
    public static int validate(String input) {
        return validateIsValidNumber(input);
    }

    private static int validateIsValidNumber(String input) {
        return ParserWrapper.parseDate(input);
    }
}
