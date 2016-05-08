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

        IntStream intStream1 = Stream.of(ints).mapToInt(x -> x);
        System.out.println("intStream1.sum() = " + intStream1.sum());

        IntStream intStream2 = IntStream.of(1, 2, 3, 4);
        intStream2.average().ifPresent(System.out::println);
    }

}
