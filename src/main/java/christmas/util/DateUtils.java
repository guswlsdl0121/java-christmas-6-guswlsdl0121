package christmas.util;

import christmas.constant.event.DateConfig;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class DateUtils {

    public static LocalDate getEventLocalDate(int day) {
        return LocalDate.of(DateConfig.YEAR.getValue(), DateConfig.MONTH.getValue(), day);
    }

    public static boolean isChristmasDay(int day) {
        return day == DateConfig.CHRISTMAS_DATE.getValue();
    }

    public static boolean isEligibleForDDayDiscount(LocalDate date) {
        return date.getDayOfMonth() <= DateConfig.CHRISTMAS_DATE.getValue();
    }

    public static boolean isWeekday(LocalDate date) {
        DayOfWeek day = date.getDayOfWeek();
        return !(day == DayOfWeek.FRIDAY || day == DayOfWeek.SATURDAY);
    }

    public static boolean isWeekend(LocalDate date) {
        DayOfWeek day = date.getDayOfWeek();
        return day == DayOfWeek.FRIDAY || day == DayOfWeek.SATURDAY;
    }
}
