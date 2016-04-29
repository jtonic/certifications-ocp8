package ro.jtonic.cert.ocp8.ch3.collection;

import java.util.*;

/**
 * Created by antonelpazargic on 29/04/16.
 */
public class Ch3Test20 {

    public static void main(String... args) {
        Map m = new HashMap();
        m.put(123, "123");
        m.put("abc", "def");
        System.out.println(m.contains("123")); // The Map API doesn't have contains method but containsKey and containsValue.
    }
}
