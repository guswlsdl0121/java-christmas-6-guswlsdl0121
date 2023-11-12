package christmas.util;

import christmas.common.util.DateUtil;
import java.time.LocalDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DateUtilTest {
    @Test
    @DisplayName("주어진 날짜의 2023년 12월의 LocalDate를 반환한다.")
    void testGetDayOfWeek() {
        //given
        LocalDate expectedDate = LocalDate.of(2023, 12, 1);

        //when
        LocalDate actualDate = DateUtil.getEventLocalDate(1);

        //then
        Assertions.assertEquals(expectedDate, actualDate);
    }
}