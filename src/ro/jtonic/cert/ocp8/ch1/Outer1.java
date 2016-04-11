package ro.jtonic.cert.ocp8.ch1;

/**
 * Created by antonelpazargic on 11/04/16.
 */
public class Outer1 {

    private String greeting = "Hi";

    private class Inner {
        private int repeat = 3;

//        private static boolean shouldNotWork; // static members are not allowed in inner classes

        private void go() {
            for(int i = 0; i < repeat; i++) {
                System.out.println(greeting);
            }
        }
    }

/*
    private void callInner() {
        Inner inner = new Inner();
        inner.go();
    }
*/

    public static void main(String... args) {
        Outer1.Inner inner = new Outer1().new Inner();
        inner.go();
    }

}
