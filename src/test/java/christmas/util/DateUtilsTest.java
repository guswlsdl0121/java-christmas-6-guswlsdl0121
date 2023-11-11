package christmas.util;

import christmas.constant.event.EventDate;
import java.time.DayOfWeek;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DateUtilsTest {
    @Test
    @DisplayName("주어진 날짜의 요일을 올바르게 반환한다.")
    void testGetDayOfWeek() {
        //given
        DayOfWeek expectedDayOfWeek = DayOfWeek.FRIDAY;

        //when
        DayOfWeek actualDayOfWeek = DateUtils.getDayOfWeek(1);

        //then
        Assertions.assertEquals(expectedDayOfWeek, actualDayOfWeek);
    }

    @Test
    @DisplayName("크리스마스 날짜 여부를 올바르게 확인한다.")
    void testIsChristmasDay() {
        Assertions.assertTrue(DateUtils.isChristmasDay(EventDate.CHRISTMAS_DATE.getValue())); // 크리스마스 날짜
        Assertions.assertFalse(DateUtils.isChristmasDay(24)); // 크리스마스 이브
    }
}
