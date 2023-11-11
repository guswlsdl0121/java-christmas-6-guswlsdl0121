package christmas.util;

import christmas.constant.event.EventDate;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class DateUtils {

    public static DayOfWeek getDayOfWeek(int day) {
        LocalDate date = LocalDate.of(EventDate.YEAR.getValue(), EventDate.MONTH.getValue(), day);
        return date.getDayOfWeek();
    }

    public static boolean isChristmasDay(int day) {
        return day == EventDate.CHRISTMAS_DATE.getValue();
    }
}
