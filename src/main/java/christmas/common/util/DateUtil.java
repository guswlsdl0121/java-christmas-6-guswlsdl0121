package christmas.common.util;

import christmas.common.constant.error.ErrorMessage;
import christmas.common.constant.event.DateConfig;
import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class DateUtil {
    // 지정된 날짜 반환
    public static LocalDate createValidDate(int day) {
        try {
            return LocalDate.of(DateConfig.YEAR.getValue(), DateConfig.MONTH.getValue(), day);
        } catch (DateTimeException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DATE.getMessage());
        }
    }

    // D-Day 이벤트 기간인지 확인
    public static boolean isInDDayEvent(LocalDate date) {
        return date.getMonthValue() == DateConfig.MONTH.getValue() &&
                date.getDayOfMonth() <= DateConfig.CHRISTMAS_DATE.getValue();
    }

    // 특별한 날인지 확인 (일요일 또는 크리스마스)
    public static boolean isSpecial(LocalDate date) {
        return isDayOfWeek(date, DayOfWeek.SUNDAY) || isChristmasDay(date);
    }

    // 평일인지 확인
    public static boolean isWeekday(LocalDate date) {
        return !isDayOfWeek(date, DayOfWeek.FRIDAY) && !isDayOfWeek(date, DayOfWeek.SATURDAY);
    }

    // 주말인지 확인
    public static boolean isWeekend(LocalDate date) {
        return isDayOfWeek(date, DayOfWeek.FRIDAY) || isDayOfWeek(date, DayOfWeek.SATURDAY);
    }

    // 특정 요일인지 확인 (도우미 메서드)
    private static boolean isDayOfWeek(LocalDate date, DayOfWeek day) {
        return date.getDayOfWeek() == day;
    }

    // 크리스마스인지 확인
    private static boolean isChristmasDay(LocalDate date) {
        return date.getMonthValue() == DateConfig.MONTH.getValue() &&
                date.getDayOfMonth() == DateConfig.CHRISTMAS_DATE.getValue();
    }
}
