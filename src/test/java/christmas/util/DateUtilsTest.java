package christmas.util;

import christmas.constant.event.DateConfig;
import java.time.LocalDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DateUtilsTest {
    @Test
    @DisplayName("주어진 날짜의 2023년 12월의 LocalDate를 반환한다.")
    void testGetDayOfWeek() {
        //given
        LocalDate expectedDate = LocalDate.of(2023, 12, 1);

        //when
        LocalDate actualDate = DateUtils.getEventLocalDate(1);

        //then
        Assertions.assertEquals(expectedDate, actualDate);
    }

    @Test
    @DisplayName("크리스마스 날짜 여부를 올바르게 확인한다.")
    void testIsChristmasDay() {
        Assertions.assertTrue(DateUtils.isChristmasDay(DateConfig.CHRISTMAS_DATE.getValue())); // 크리스마스 날짜
        Assertions.assertFalse(DateUtils.isChristmasDay(24)); // 크리스마스 이브
    }
}
