package christmas.common.util.parser;

import christmas.common.constant.message.ErrorMessage;
import christmas.common.util.DateUtils;
import christmas.common.util.validator.DateValidator;
import java.time.DateTimeException;
import java.time.LocalDate;

public class DateInputParser implements InputParser<LocalDate> {

    @Override
    public LocalDate parse(String input) {
        int day = DateValidator.validate(input);
        return convertToValidDate(day);
    }

    private LocalDate convertToValidDate(int day) {
        try {
            // 날짜 범위 검증은 LocalDate.of 메서드에 의해 처리됨.
            return DateUtils.getEventLocalDate(day);
        } catch (DateTimeException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DATE.getMessage());
        }
    }
}
