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

        System.out.println("conversion of streams");
        IntStream.rangeClosed(1, 10).mapToObj(Integer::valueOf).forEach(System.out::println);
        IntStream.range(1, 6).mapToDouble(Double::valueOf).forEach(System.out::println);

        System.out.println("conversion from of stream of Strings to a stream of integers.");
        Stream<String> str1 = Stream.of("Penguin", "Fish");
        str1.mapToInt(String::length).forEach(System.out::println);

        IntStream.rangeClosed(1, 5).mapToObj(new IntFunction<String>() {
            @Override
            public String apply(int value) {
                return Integer.toString(value);
            }
        }).forEach(System.out::println);

        IntStream.rangeClosed(1, 5).map(new IntUnaryOperator() {
            @Override
            public int applyAsInt(int operand) {
                return operand * 2;
            }
        }).forEach(System.out::println);

        IntStream.rangeClosed(1, 5).mapToDouble(new IntToDoubleFunction() {
            @Override
            public double applyAsDouble(int value) {
                return value;
            }
        }).forEach(System.out::println);

    }

}
