package ro.jtonic.cert.ocp8.ch5;

import java.time.*;
/**
 * Created by antonelpazargic on 15/05/16.
 */
public class Test16 {

    public static void main(String... args) {
        // LocalDate.now().toInstant(); // doesn't compile -  method doesn't exists
        // LocalDateTime.now().toInstant(); // doesn't compile - the zone offset is not provided as a argument
        // LocalTime.toInstant(); // doesn't compile - method doesn't exists
    }
}
