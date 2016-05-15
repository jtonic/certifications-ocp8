package ro.jtonic.cert.ocp8.ch5;

import java.time.*;
import java.time.zone.*;

/**
 * Created by antonelpazargic on 15/05/16.
 */
public class DaylightSavingTimeTest {

    public static void main(String... args) {
        System.out.println("===============");
        System.out.println("Spring forward");
        System.out.println("===============");
        LocalDate ld1 = LocalDate.of(2016, Month.MARCH, 13);
        LocalTime lt1 = LocalTime.of(1, 30);
        ZoneId zid1 = ZoneId.of("US/Eastern");
        ZonedDateTime zdt1 = ZonedDateTime.of(ld1, lt1, zid1);
        System.out.println("zdt1 = " + zdt1);
        zdt1 = zdt1.plusHours(1);
        System.out.println("zdt1 = " + zdt1);

        LocalTime lt2 = LocalTime.of(2, 30);
        ZonedDateTime zdt2 = ZonedDateTime.of(ld1, lt2, zid1);
        System.out.println("zdt2 = " + zdt2);

        System.out.println("===============");
        System.out.println("Fall fall back");
        System.out.println("===============");
        LocalDate ld2 = LocalDate.of(2016, Month.NOVEMBER, 6);
        ZonedDateTime zdt3 = ZonedDateTime.of(ld2, lt1, zid1);
        System.out.println("zdt3 = " + zdt3);
        zdt3 = zdt3.plusHours(1);
        System.out.println("zdt3 = " + zdt3);
    }
}
