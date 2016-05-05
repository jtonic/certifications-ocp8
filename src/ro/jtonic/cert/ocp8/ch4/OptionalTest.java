package ro.jtonic.cert.ocp8.ch4;

import java.util.function.*;
import java.util.*;

/**
 * Created by antonelpazargic on 04/05/16.
 */
public class OptionalTest {

    public static void main(String... args) {

        Optional<List<String>> o1 = Optional.of(Arrays.asList("tiger", "bear", "elephant"));
        o1.ifPresent(System.out::println);

        Optional<String> empty = Optional.empty();
        if (empty.isPresent()) {
            System.out.println(empty.get());
        } else {
            System.out.println("The optional is empty");
            //            empty.get();
        }

        empty.ifPresent(System.out::println);

        System.out.println(empty.orElse("n/a"));
        System.out.println(empty.orElseGet(() -> "not available"));

        Optional<Double> o2 = Optional.empty();
        final Double no = o2.orElse(Double.NaN);
        System.out.println(no);

        empty.orElseThrow(() -> new RuntimeException("The optional is empty"));
    }
}
