package christmas.common.util.parser;

import christmas.common.constant.message.ErrorMessage;
import christmas.common.util.DateUtils;
import java.time.DateTimeException;
import java.time.LocalDate;

public class DateInputNumberParser extends AbstractNumberParser<LocalDate> {

    @Override
    public LocalDate parse(String input) {
        validateInParsing(input);
        return convert(input);
    }

    @Override
    protected LocalDate convert(String input) {
        try {
            int dateInput = Integer.parseInt(input);
            return convertToLocalDate(dateInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
        }
    }

    private LocalDate convertToLocalDate(int day) {
        try {
            return DateUtils.getEventLocalDate(day);
        } catch (DateTimeException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DATE.getMessage());
        }
    }
}
