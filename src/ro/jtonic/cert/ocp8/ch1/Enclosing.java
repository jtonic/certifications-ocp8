package ro.jtonic.cert.ocp8.ch1;

/**
 * Created by antonelpazargic on 11/04/16.
 */
public class Enclosing {
    private static class Nested {
        private int price = 6;
    }

    public static void main(String... args) {
        Nested nested = new Nested();
        System.out.println(nested.price);
    }
}
