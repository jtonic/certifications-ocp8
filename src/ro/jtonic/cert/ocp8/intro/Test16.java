package ro.jtonic.cert.ocp8.intro;

/**
 * Created by antonelpazargic on 05/04/16.
 */

import java.time.Duration;
import java.time.Period;

public class Test16 {

    public static void main(String[] args) {
        String d = Duration.ofDays(1).toString();
        String t = Period.ofDays(1).toString();

        boolean b1 = d == t;
        boolean b2 = d.equals(t);
        System.out.println(b1 + " " + b2);
        System.out.println(d + " " + t);
    }

}
