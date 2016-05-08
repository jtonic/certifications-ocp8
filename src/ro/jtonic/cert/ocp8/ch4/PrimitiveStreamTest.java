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


        System.out.println("===== Optionals for primitives======");
        final OptionalDouble avg = IntStream.rangeClosed(1, 10).average();
        if (avg.isPresent()) {
            System.out.println("Average: " + avg.getAsDouble());
        } else {
            System.out.println("n/a");
        }

        final double avg2 = avg.orElseGet(new DoubleSupplier() {
            @Override
            public double getAsDouble() {
                return Double.NaN;
            }
        });
        System.out.println("Average: " + avg2);


        DoubleStream str2 = DoubleStream.of(1, 10);
        final double sum1 = str2.sum();
        System.out.println("sum1: " + sum1);

        // The next stream pipeline of operations will run infinitely
        // DoubleStream str3 = DoubleStream.generate(Math::random);
        // final double sum2 = str3.sum();
        // System.out.println("sum2: " + sum2);

        System.out.println("Compute the subtract between the max and min of the ints in the stream");
        int range = range(IntStream.rangeClosed(1, 10));
        System.out.println(range);

        max(IntStream.empty());
    }

    private static int max(IntStream ints) {
        OptionalInt maxOpt = ints.max();
        return maxOpt.orElseThrow(() -> new RuntimeException("Cannot compute max for no data"));
    }

    /**
     * This returns the substract between the max and min value of the ints stream
     * @param ints
     * @return
     */
    private static int range(IntStream ints) {
        IntSummaryStatistics stats = ints.summaryStatistics();
        if (stats.getCount() == 0) {
            throw new RuntimeException("Cannot perform statistics on an empty stream");
        }
        return stats.getMax() - stats.getMin();
    }

}
