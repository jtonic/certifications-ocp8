package ro.jtonic.cert.ocp8.ch5.localization;

import java.time.*;
import java.time.format.FormatStyle;
import java.time.format.DateTimeFormatter;
/**
 * Created by antonelpazargic on 11/05/16.
 */
public class DateAndTimeFormatAndParseTest {

    public static void main(String... args) {
        LocalDate ld1 = LocalDate.of(2020, Month.JANUARY, 29);
        System.out.println("year: " + ld1.getYear());
        System.out.println("day of the week: " + ld1.getDayOfWeek());
        System.out.println("day of the year: " + ld1.getDayOfYear());
        System.out.println("day of the month: " + ld1.getDayOfMonth());

        // formatting date, time and datetime
        System.out.println("=============================");
        System.out.println("ISO date and time formatting");
        System.out.println("=============================");
        LocalTime lt1 = LocalTime.of(23, 30, 0);
        LocalDateTime ldt1 = LocalDateTime.of(ld1, lt1);

        System.out.println("ld1.format(DateTimeFormatter.ISO_DATE) = " + ld1.format(DateTimeFormatter.ISO_DATE));
        System.out.println("lt1.format(DateTimeFormatter.ISO_TIME) = " + lt1.format(DateTimeFormatter.ISO_TIME));
        System.out.println("ldt1.format(DateTimeFormatter.ISO_DATE_TIME) = " + ldt1.format(DateTimeFormatter.ISO_DATE_TIME));

        System.out.println("=============================");
        System.out.println("formatting using localized date formatter");
        System.out.println("=============================");
        DateTimeFormatter sdf1 = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        DateTimeFormatter stf1 = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
        System.out.println("sdf1.format(ld1) = " + sdf1.format(ld1));
        System.out.println("sdf1.format(ldt1) = " + sdf1.format(ldt1));
        // System.out.println("sdf1.format(lt1) = " + sdf1.format(lt1)); // Exception in thread "main" java.time.temporal.UnsupportedTemporalTypeException: Unsupported field: MonthOfYear
        System.out.println("stf1.format(stf1) = " + stf1.format(lt1));

        System.out.println("=============================");
        System.out.println("The same SHORT formatting but calling the format method on Local(Date|Time|DateTime)");
        System.out.println("=============================");
        System.out.println("ld1.format(sdf1) = " + ld1.format(sdf1));
        System.out.println("ldt1.format(sdf1) = " + ldt1.format(sdf1));
        // System.out.println("lt1.format(sdf1) = " + lt1.format(sdf1)); // Exception in thread "main" java.time.temporal.UnsupportedTemporalTypeException: Unsupported field: MonthOfYear

        System.out.println("=============================");
        System.out.println("The MEDIUM date time format");
        System.out.println("=============================");
        DateTimeFormatter mdtf = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        DateTimeFormatter mtf = DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM);
        DateTimeFormatter mdf = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
        System.out.println("mdf.format(ld1) = " + mdf.format(ld1));
        System.out.println("mtf.format(lt1) = " + mtf.format(lt1));
        System.out.println("mdtf.format(ldt1) = " + mdtf.format(ldt1));

        System.out.println("=============================");
        System.out.println("Custom date time formatting");
        System.out.println("=============================");
        DateTimeFormatter cdtf1 = DateTimeFormatter.ofPattern("MMMM dd, yyyy, hh:mm");
        DateTimeFormatter cdtf2 = DateTimeFormatter.ofPattern("MMM d, yy, h:m");
        System.out.println("ldt1.format(cdtf1) = " + ldt1.format(cdtf1));
        System.out.println("cdtf2.format(ldt1) = " + cdtf2.format(LocalDateTime.of(LocalDate.of(2016, 1, 3), LocalTime.of(13, 5, 9))));

        DateTimeFormatter ctf1 = DateTimeFormatter.ofPattern("hh:mm");
        System.out.println("lt1.format(ctf1) = " + lt1.format(ctf1));
        System.out.println("ldt1.format(ctf1) = " + ldt1.format(ctf1));
        // System.out.println("ld1.format(ctf1) = " + ld1.format(ctf1)); // java.time.temporal.UnsupportedTemporalTypeException: Unsupported field: ClockHourOfAmPm

        System.out.println("=============================");
        System.out.println("Parsing date and time");
        System.out.println("=============================");

        DateTimeFormatter cdtf3 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        final LocalDate localDate = LocalDate.parse("2016-01-29", cdtf3);
        System.out.println("localDate = " + localDate);

        lt1 = LocalTime.parse("23:30", DateTimeFormatter.ofPattern("HH:mm"));
        System.out.println("lt1 = " + lt1);
        lt1 = LocalTime.parse("11:30 PM", DateTimeFormatter.ofPattern("hh:mm a"));
        System.out.println("lt1 = " + lt1.format(DateTimeFormatter.ISO_TIME));

    }

}
