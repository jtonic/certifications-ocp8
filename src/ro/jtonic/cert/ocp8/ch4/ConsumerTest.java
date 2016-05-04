package ro.jtonic.cert.ocp8.ch4;

import java.util.function.*;
import java.util.*;

/**
 * Created by antonelpazargic on 04/05/16.
 */
public class ConsumerTest {

    public static void main(String... args) {
        Consumer<String> c1 = System.out::println;
        Consumer<String> c2 = s -> System.out.println(s);

        c1.accept("jtonic");
        c2.accept("tutye");

        Map<String, Integer> map = new HashMap<>();
        BiConsumer<String, Integer> c3 = map::put;
        BiConsumer<String, Integer> c4 = (k, v) -> map.put(k, v);

        c3.accept("jtonic", 46);
        c3.accept("tutye", 33);

        System.out.println(map);
    }

}
