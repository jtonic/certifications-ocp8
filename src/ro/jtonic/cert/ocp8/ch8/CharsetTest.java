package ro.jtonic.cert.ocp8.ch8;

import java.nio.charset.*;
/**
 * Created by antonelpazargic on 02/06/16.
 */
public class CharsetTest {

    public static void main(String... args) {
        Charset defaultCs = Charset.defaultCharset();
        System.out.println("Default charset: " + defaultCs); // toString uses name()
        System.out.println("defaultCs.displayName() = " + defaultCs.displayName());
        System.out.println("defaultCs.name() = " + defaultCs.name());
        System.out.println("defaultCs.isRegistered() = " + defaultCs.isRegistered());
        for (String alias : defaultCs.aliases()) {
            System.out.println("Alias: " + alias);
        }

        Charset utf8 = Charset.forName("utf8");
        System.out.println("utf8.name() = " + utf8.name());
    }

}
