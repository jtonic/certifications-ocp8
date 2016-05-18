package ro.jtonic.cert.ocp8.ch6;

import ro.jtonic.cert.ocp8.ch6.ea.*;
import static ro.jtonic.cert.ocp8.ch6.ea.Zoo.Seasons.*;

/**
 * Created by antonelpazargic on 17/05/16.
 */
public class AssertionTest {


    public static void main(String... args) {
        Zoo zoo = new Zoo(100);
        zoo.getOpeningHours(SPRING);
        zoo.getOpeningHours(WINTER);

        zoo = new Zoo(-1);
        int visNo = zoo.getVisitorsNumber();
        System.out.println("Zoo visitors number: " + visNo);

        int visitorsNumber = -1;
        assert visitorsNumber > 0;
        assert visitorsNumber > 0 : "There are visitors int the Zoo";
        System.out.println("The number of visitors: " + visitorsNumber);

    }
}
