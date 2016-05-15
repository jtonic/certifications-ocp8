package ro.jtonic.cert.ocp8.ch5;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.concurrent.*;
import java.time.temporal.*;

/**
 * Created by antonelpazargic on 09/05/16.
 */
public class DateTimeTest {

    public static void main(String... args) throws InterruptedException {
        final Instant inst1 = Instant.now();
        final ZonedDateTime zdt2 = inst1.atZone(ZoneId.of("US/Eastern"));
        System.out.println(zdt2);
        // final DateTimeFormatter dtf10 = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
        // System.out.println("dtf10.format(inst1) = " + dtf10.format(inst1));

        LocalDate now = LocalDate.now();
        final LocalDate lastDayForExamPrep = now.plusDays(62);
        String ldep = lastDayForExamPrep.format(DateTimeFormatter.ofPattern("EEEE, dd MMMM YYYY"));
        System.out.println("lastDayForExamPrep = " + ldep);

        LocalDate date = LocalDate.of(2016, Month.MAY, 10);
        date.plusDays(10);
        System.out.println(date);

        // date.plusMinutes(10); this doesn't compile 'cause date doesn't contain time elements.
        Period p = Period.of(1, 2, 3);
        System.out.println(p);
        p = Period.of(1, 0, 3);
        System.out.println(p);
        p = Period.ofWeeks(3);
        System.out.println(p);

        Instant now1 = Instant.now();
        System.out.println("Some processing...");
        TimeUnit.SECONDS.sleep(2);
        Instant end1 = Instant.now();
        System.out.println("Duration: " + Duration.between(now1, end1));
        System.out.println("Duration in milliseconds:" + Duration.between(now1, end1).toMillis());

        System.out.println("ZonedDateTime");
        System.out.println("======================");
        System.out.println("ZonedDateTime.now() = " + ZonedDateTime.now());

        System.out.println("======================");
        System.out.println("LocalDateTime default toString()");
        System.out.println("======================");
        System.out.println("LocalDateTime.now() = " + LocalDateTime.now());

        System.out.println("======================");
        System.out.println("Print all available zoneIds from Europe");
        System.out.println("======================");
        ZoneId.getAvailableZoneIds().stream().filter(s -> s.toLowerCase().startsWith("europe")).forEach(System.out::println);
        System.out.println("ZonedDateTime.now(ZoneId.of(\"Europe/Bucharest\")) = " + ZonedDateTime.now(ZoneId.of("Europe/Bucharest")));
        System.out.println("ZonedDateTime.now(ZoneId.of(\"Europe/Brussels\")) = " + ZonedDateTime.now(ZoneId.of("Europe/Brussels")));
        System.out.println("ZonedDateTime.now(ZoneId.of(\"Europe/Paris\")) = " + ZonedDateTime.now(ZoneId.of("Europe/Paris")));
        System.out.println("ZonedDateTime.now(ZoneId.of(\"Europe/London\")) = " + ZonedDateTime.now(ZoneId.of("Europe/London")));

        System.out.println("======================");
        System.out.println("See the time difference between two timezones -  Paris and Kolkata");
        System.out.println("======================");
        System.out.println("ZonedDateTime.now(ZoneId.of(\"Europe/Paris\")) = " + ZonedDateTime.now(ZoneId.of("Europe/Paris")));
        System.out.println("ZonedDateTime.now(\"Asia/Kolkata\") = " + ZonedDateTime.now(ZoneId.of("Asia/Kolkata")));

        System.out.println("======================");
        System.out.println("The available America timezones");
        System.out.println("======================");
        ZoneId.getAvailableZoneIds().stream().filter(s -> s.toLowerCase().startsWith("america")).forEach(System.out::println);

        final LocalDate mayLd = LocalDate.of(2016, Month.MAY, 14);
        ZonedDateTime nyZdt = ZonedDateTime.of(mayLd, LocalTime.of(16, 6, 0), ZoneId.of("America/New_York"));
        ZonedDateTime londonZdt = ZonedDateTime.of(mayLd, LocalTime.of(23, 6, 0), ZoneId.of("Europe/London"));
        ZonedDateTime losAngZdt = ZonedDateTime.of(mayLd, LocalTime.of(12, 6, 0), ZoneId.of("America/Los_Angeles"));
        System.out.println("londonZdt = " + londonZdt);
        System.out.println("nyZdt = " + nyZdt);
        System.out.println("losAngZdt = " + losAngZdt);

        System.out.println("LocalTime.of(10, 10) = " + LocalTime.of(10, 10));
        System.out.println("LocalTime.of(10, 12, 12) = " + LocalTime.of(10, 12, 12));
        System.out.println("LocalTime.of(10, 11, 12, 130) = " + LocalTime.of(10, 11, 12, 130));

        System.out.println("======================");
        System.out.println("Default ZoneId");
        System.out.println("======================");
        System.out.println("ZoneId.systemDefault() = " + ZoneId.systemDefault());

        System.out.println("======================");
        System.out.println("Available US timezones");
        System.out.println("======================");
        ZoneId.getAvailableZoneIds().stream().filter(s -> s.toLowerCase().startsWith("us")).forEach(System.out::println);

        System.out.println("ZonedDateTime.now(ZoneId.of(\"US/Pacific\")) = " + ZonedDateTime.now(ZoneId.of("US/Pacific")));

        LocalDateTime ldt1 = LocalDateTime.of(mayLd, LocalTime.of(10, 11, 12));
        ZonedDateTime zdt1 = ZonedDateTime.of(ldt1, ZoneId.of("US/Pacific"));
        System.out.println("zdt1 = " + zdt1);

        System.out.println("======================");
        System.out.println("Working with duration and period");
        System.out.println("======================");
        final LocalDateTime nextYear = LocalDateTime.now().plus(Period.ofYears(1)).plus(Duration.ofHours(3));
        System.out.println("nextYear = " + nextYear);


        Duration daily = Duration.of(1, ChronoUnit.DAYS);
        Duration hourly = Duration.of(1, ChronoUnit.HOURS);
        ldt1 = LocalDateTime.now().plus(daily).plus(hourly);
        System.out.println("ldt1 = " + ldt1);

        LocalTime lt1 = LocalTime.now();
        LocalTime lt2 = LocalTime.of(22, 30);
        System.out.println("ChronoUnit.HOURS.between(lt2, lt1) = " + ChronoUnit.HOURS.between(lt2, lt1));
        System.out.println("ChronoUnit.HOURS.between(lt1, lt2) = " + ChronoUnit.HOURS.between(lt1, lt2));
    }

}
