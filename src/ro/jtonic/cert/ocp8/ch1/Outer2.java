package ro.jtonic.cert.ocp8.ch1;

/**
 * Created by antonelpazargic on 11/04/16.
 */
public class Outer2 {
    private int length = 5;

    public void calculate() {
        int width = 20;
        class Inner {
//            public static boolean doesntWork; // non final static fields cannot be used in inner classes
            public static final boolean DOES_WORK = true; // but final static constants can be used in inner classes

            public void multiply() {
                System.out.println(length * width);
            }
        }
        Inner inner = new Inner();
        System.out.println("Inner.DOES_WORK = " + Inner.DOES_WORK);
        inner.multiply();
    }

    public static void main(String... args) {
        Outer2 outer = new Outer2();
        outer.calculate();
    }

}
