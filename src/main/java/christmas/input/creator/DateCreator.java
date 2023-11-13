package christmas.input.creator;

import christmas.common.util.DateUtil;
import christmas.input.result.DateParseResult;
import java.time.LocalDate;

public class DateCreator implements ResultCreator<DateParseResult, LocalDate> {
    @Override
    public LocalDate create(DateParseResult inputResult) {
        return DateUtil.createValidDate(inputResult.day());
    }
}
