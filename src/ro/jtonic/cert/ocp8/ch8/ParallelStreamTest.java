package ro.jtonic.cert.ocp8.ch8;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;
/**
 *
 * Created by antonelpazargic on 26/05/16.
 */
public class ParallelStreamTest {

    public static void main(String... args) {

        // processing serial stream
        final List<Integer> lst = Arrays.asList(1, 2, 3, 4);
        System.out.println("Serial stream processing");
        final Stream<Integer> stream = lst.stream();
        stream.forEach(System.out::println);

        // processing parallel stream
        // stream.parallel().forEach(System.out::println); // java.lang.IllegalStateException: stream has already been operated upon or closed

        // real processing of the parallel stream
        System.out.println("Parallel stream processing");
        lst.parallelStream().forEach(System.out::println);

        System.out.println("Transforming a serial stream into a parallel stream");

        IntStream intStream = IntStream.rangeClosed(1, 100);
        System.out.println("Is the stream parallel? " + intStream.isParallel());
        IntStream parStream = intStream.parallel();

        System.out.println("Is the stream parallel? " + parStream.isParallel());

        Integer sum = parStream.sum();
        System.out.println("Sum = " + sum);

        Stream<String> str1 = Stream.of("1", "2", "3", "4", "5");
        Stream<String> str2 = Stream.of("one", "two", "three", "four", "five").parallel();
        final Stream<String> concatStr = Stream.concat(str1, str2);
        concatStr.forEach(System.out::println);
        System.out.println("Is concatStr parallel? " + concatStr.isParallel());

        // parallel stream does not process the stream in order, but this can be imposed at the cost of performance with forEachOrdered
        System.out.println("forEach for parallel stream");
        System.out.println("================");
        final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        numbers.parallelStream().forEach(System.out::print);
        System.out.println("forEachOrdered for parallel stream");
        System.out.println("=========");
        numbers.parallelStream().forEachOrdered(System.out::print);

    }

}
