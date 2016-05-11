package ro.jtonic.cert.ocp8.ch5;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.*;

/**
 * Created by antonelpazargic on 09/05/16.
 */
public class DateTimeTest {

    public static void main(String... args) throws InterruptedException {
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

    }

}
