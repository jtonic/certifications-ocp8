package ro.jtonic.cert.ocp8.ch1;

/**
 * Created by antonelpazargic on 08/04/16.
 */
public class InstanceOfTest {

    public static void main(String[] args) {
        boolean a = null instanceof Object;
        System.out.println("a = " + a);

        String str = null;
        System.out.println("str instanceof Object = " + (str instanceof Object));
    }

}
