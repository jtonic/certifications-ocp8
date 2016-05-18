package ro.jtonic.cert.ocp8.ch6;

/**
 * Created by antonelpazargic on 17/05/16.
 */
public class MultiCatchTest {

    public static void main(String... args) {
        try {
            throw new IllegalArgumentException("thrown");
        } catch (IllegalArgumentException | IllegalStateException e) {
            e = new IllegalStateException("aaaa");
            throw e;
        }
    }
}
