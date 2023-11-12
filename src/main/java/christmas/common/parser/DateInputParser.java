package christmas.common.parser;

import christmas.common.constant.error.ErrorMessage;
import christmas.common.util.DateUtil;
import christmas.common.validator.DateValidator;
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
            return DateUtil.getEventLocalDate(day);
        } catch (DateTimeException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DATE.getMessage());
        }
    }
}
