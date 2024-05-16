package web.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtilityService {

    public static String dateAfter(String date) {
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
        LocalDate newDate = localDate.plusDays(1);
        return newDate.format(DateTimeFormatter.ISO_DATE);
    }

    public static String dateBefore(String date) {
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
        LocalDate newDate = localDate.minusDays(1);
        return newDate.format(DateTimeFormatter.ISO_DATE);
    }
}
