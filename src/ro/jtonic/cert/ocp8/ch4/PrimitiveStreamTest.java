package ro.jtonic.cert.ocp8.ch4;

import java.util.stream.*;
import java.util.*;
import java.util.function.*;

/**
 * Created by antonelpazargic on 08/05/16.
 */
public class PrimitiveStreamTest {

    public static void main(String... args) {
        final Integer[] ints = {1, 2, 3, 4};
        final Integer sum = Stream.of(ints).reduce(0, (a, b) -> a + b);
        System.out.println("sum = " + sum);

        IntStream is1 = Stream.of(ints).mapToInt(x -> x);
        System.out.println("is1.sum() = " + is1.sum());

        IntStream is2 = IntStream.of(1, 2, 3, 4);
        is2.average().ifPresent(System.out::println);

        IntStream.range(1, 6).forEach(System.out::println);
        IntStream.rangeClosed(1, 5).forEach(System.out::println);

        System.out.println("==== generate primitives streams using Random=======");
        new Random().ints(5).forEach(System.out::println);
        new Random().doubles(5).forEach(System.out::println);
    }

}
