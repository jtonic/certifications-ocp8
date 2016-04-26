package ro.jtonic.cert.ocp8.ch3.generics;

import java.util.*;

/**
 * Created by antonelpazargic on 26/04/16.
 */
public class LegacyAutoboxing {

    public static void main(String... args) {
        List numbers = new ArrayList();
        numbers.add(5);
        int result = numbers.get(0);
    }

}
