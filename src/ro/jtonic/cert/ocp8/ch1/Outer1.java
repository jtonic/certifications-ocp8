package ro.jtonic.cert.ocp8.ch1;

/**
 * Created by antonelpazargic on 11/04/16.
 */
public class Outer1 {

    private String greeting = "Hi";

    private static class StaticNestedClass {
        private static int foo;
        private static int boo() {
            return 1;
        }
    }

    private class Inner {
        private int repeat = 3;

        private static final boolean THIS_WORKS = false; // static members are not allowed but final static constants are allowed
//        private static boolean thisDoesntWork; // static members are not allowed but final static constants are allowed

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
        System.out.println("Inner.THIS_WORKS: " + Inner.THIS_WORKS);

        System.out.println(StaticNestedClass.boo());
    }

}
