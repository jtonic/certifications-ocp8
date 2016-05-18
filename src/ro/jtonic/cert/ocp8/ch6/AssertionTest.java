package ro.jtonic.cert.ocp8.ch6;

/**
 * Created by antonelpazargic on 17/05/16.
 */
public class AssertionTest {


    public static void main(String... args) {
        int visitorsNumber = -1;
        assert visitorsNumber > 0;
        assert visitorsNumber > 0 : "There are visitors int the Zoo";
        System.out.println("The number of visitors: " + visitorsNumber);

    }
}
