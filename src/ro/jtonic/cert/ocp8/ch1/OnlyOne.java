package ro.jtonic.cert.ocp8.ch1;

/**
 * Created by antonelpazargic on 09/04/16.
 */
public enum OnlyOne {
    ONCE(true);

    OnlyOne(boolean b) {
        System.out.println("constructing...");
    }

    public static void main(String... args) {
        final OnlyOne once = OnlyOne.ONCE;
        final OnlyOne twice = OnlyOne.ONCE;
    }
}
