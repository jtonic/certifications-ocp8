package ro.jtonic.cert.ocp8.ch5;

import java.time.*;
import java.time.temporal.*;

/**
 * Created by antonelpazargic on 15/05/16.
 */
public class Test15 {

    public static void main(String... args) {
        Duration d1 = Duration.of(1, ChronoUnit.MINUTES);
        Duration d2 = Duration.of(60, ChronoUnit.SECONDS);
        Duration d3 = Duration.of(10, ChronoUnit.SECONDS);
        System.out.println("d1 = " + d1);
        System.out.println("d2 = " + d2);
        System.out.println("d1.equals(d2) = " + d1.equals(d2));
        System.out.println("d3 = " + d3);
    }
}
