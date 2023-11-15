package christmas.util;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import christmas.common.constant.error.ErrorMessage;
import christmas.common.constant.event.DateConfig;
import christmas.common.util.DateUtil;
import java.time.LocalDate;
import java.time.Month;
import org.junit.jupiter.api.Test;

class DateUtilTest {

    @Test
    void testCreateValidDate() {
        assertDoesNotThrow(() -> DateUtil.createValidDate(15)); // 유효한 날짜
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            DateUtil.createValidDate(32); // 유효하지 않은 날짜
        });
        assertEquals(ErrorMessage.INVALID_DATE.getMessage(), exception.getMessage());
    }

    @Test
    void testIsInDDayEvent() {
        LocalDate dDayEventDate = LocalDate.of(DateConfig.YEAR.getValue(), DateConfig.MONTH.getValue(), 20);
        assertTrue(DateUtil.isInDDayEvent(dDayEventDate));

        LocalDate notDDayEventDate = LocalDate.of(DateConfig.YEAR.getValue(), DateConfig.MONTH.getValue(), 26);
        assertFalse(DateUtil.isInDDayEvent(notDDayEventDate));
    }

    @Test
    void testIsSpecial() {
        LocalDate sunday = LocalDate.of(2023, Month.DECEMBER, 25); // 일요일
        assertTrue(DateUtil.isSpecial(sunday));

        LocalDate christmasDay = LocalDate.of(2023, Month.DECEMBER, 25); // 크리스마스
        assertTrue(DateUtil.isSpecial(christmasDay));

        LocalDate ordinaryDay = LocalDate.of(2023, Month.DECEMBER, 20); // 특별하지 않은 날
        assertFalse(DateUtil.isSpecial(ordinaryDay));
    }

    @Test
    void testIsWeekday() {
        LocalDate weekday = LocalDate.of(2023, Month.DECEMBER, 20); // 평일
        assertTrue(DateUtil.isWeekday(weekday));

        LocalDate weekend = LocalDate.of(2023, Month.DECEMBER, 16); // 주말
        assertFalse(DateUtil.isWeekday(weekend));
    }

    @Test
    void testIsWeekend() {
        LocalDate weekend = LocalDate.of(2023, Month.DECEMBER, 23); // 주말
        assertTrue(DateUtil.isWeekend(weekend));

        LocalDate weekday = LocalDate.of(2023, Month.DECEMBER, 24); // 평일
        assertFalse(DateUtil.isWeekend(weekday));
    }
}
