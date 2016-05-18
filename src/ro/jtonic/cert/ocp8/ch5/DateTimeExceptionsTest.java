package ro.jtonic.cert.ocp8.ch5;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

/**
 * Created by antonelpazargic on 09/05/16.
 */
public class DateTimeExceptionsTest {

    public static void main(String... args) {
        LocalDate ld = LocalDate.now();

        // The following formatting doesn't work
        // java.time.temporal.UnsupportedTemporalTypeException: Unsupported field: ClockHourOfAmPm
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mm");
        System.out.println("ld.format(dtf) = " + ld.format(dtf));

        Duration d = Duration.ofHours(1);
        // The duration cannot be added to a LocalDate
        // java.time.temporal.UnsupportedTemporalTypeException: Unsupported unit: Seconds
        ld.plus(d);
        System.out.println("d = " + d);
        System.out.println("ld = " + ld);

        // LocalDate.of(2016, Month.JANUARY, 32); //java.time.DateTimeException: Invalid value for DayOfMonth (valid values 1 - 28/31): 32

        // LocalTime.of(25, 10); //java.time.DateTimeException: Invalid value for HourOfDay (valid values 0 - 23): 25

        // final ZoneId usEastZid = ZoneId.of("us/Eastern"); //java.time.zone.ZoneRulesException: Unknown time-zone ID: us/Eastern
        // System.out.println("usEastZid = " + usEastZid);

        // LocalDate.now().plusMinutes(10); // Doesn't compile
        // LocalTime.now().plusDays(1); // doesn't compile

        // LocalDate ld1 = LocalDate.now().plus(Duration.ofHours(10)); //java.time.temporal.UnsupportedTemporalTypeException: Unsupported unit: Seconds
        // LocalDate ld1 = LocalDate.now().plus(Duration.ofDays(1)); // java.time.temporal.UnsupportedTemporalTypeException: Unsupported unit: Seconds
        // LocalTime.now().plus(Period.ofDays(1)); // java.time.temporal.UnsupportedTemporalTypeException: Unsupported unit: Days

    }

}
