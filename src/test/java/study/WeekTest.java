package study;

import christmas.constant.event.DateConfig;
import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WeekTest {
    @Test
    @DisplayName("년, 월, 일을 입력하고 LocalDate를 생성하면 getDayOfWeek를 통해 요일 객체를 생성할 수 있다.")
    void testFindWeekInDecember() {
        //given
        LocalDate testDay = LocalDate.of(DateConfig.YEAR.getValue(), DateConfig.MONTH.getValue(), 1);

        //when
        DayOfWeek testDayOfWeek = testDay.getDayOfWeek();

        //then
        Assertions.assertEquals(DayOfWeek.FRIDAY, testDayOfWeek);
    }

    @Test
    @DisplayName("잘못된 날짜를 입력했을 떄 에러 생성 확인")
    void testExceptionInvalidDate() {
        //given
        int invalidDay = 32; // 12월에는 31일까지만 존재

        //then
        Assertions.assertThrows(
                DateTimeException.class,
                () -> LocalDate.of(DateConfig.YEAR.getValue(),
                DateConfig.MONTH.getValue(), invalidDay));
    }
}
