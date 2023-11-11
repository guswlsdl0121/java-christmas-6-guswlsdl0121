package christmas.util;

import christmas.constant.event.DateConfig;
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
}
