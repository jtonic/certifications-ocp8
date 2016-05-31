package ro.jtonic.cert.ocp8.ch7;

import java.util.*;
import java.util.stream.*;
import java.util.concurrent.*;
/**
 *
 * Created by antonelpazargic on 26/05/16.
 */
public class ParallelStreamTest {

    public static void main(String... args) {
        final List<Integer> ints = Arrays.asList(1, 2, 3, 4, 5);
        final List<String> chars = Arrays.asList("w", "o", "l", "f");

        System.out.println("Sorting the elements of a parallel stream using a concurrent sorted collection such as ConcurrentSkipListSet.");
        final ConcurrentSkipListSet<String> collect = chars.parallelStream().collect(ConcurrentSkipListSet::new, Set::add, Set::addAll);
        System.out.println(collect);

        System.out.println("Parallel reduction of a stream.");
        final String[] animalsArray = {"lions", "tigers", "bears"};
        Stream<String> animals = Stream.of(animalsArray);
        ConcurrentMap<Integer, String> map = animals.collect(Collectors.toConcurrentMap(String::length, k -> k, (s1, s2) -> s1 + " - " + s2));
        System.out.println("Mapped animals by name characters count - " + map);
        System.out.println(map.getClass().getName());

        final ConcurrentMap<Integer, List<String>> coll2 = Stream.of(animalsArray).parallel().collect(Collectors.groupingByConcurrent(String::length));
        System.out.println("coll2 = " + coll2);

        System.exit(0);

        String concat = chars.parallelStream().reduce("", (c, s) -> c + s, (s1, s2) -> s1 + s2);
        System.out.println("concat: " + concat);

        System.out.println("Example of incorrect reduction result when the identity is not correctly chosen");
        final String concatenation = chars.parallelStream().reduce("X", String::concat);
        System.out.println("concatenation: " + concatenation);


        final Integer findAny3 = ints.stream().unordered().findAny().orElse(-1);
        System.out.println("findAny3: " + findAny3);



        final Integer findAny = ints.stream().findAny().orElse(-1);
        System.out.println("findAny: " + findAny);
        final Integer findFirst = ints.stream().findFirst().orElseThrow(() -> new RuntimeException("No entries in the stream."));
        System.out.println("findFirst = " + findFirst);

        final Integer findAny2 = ints.parallelStream().findAny().orElse(-1);
        System.out.println("findAny2: " + findAny2);

        System.out.println("findFirst is not quick (performant) in parallelStreams since the results need to be synchronized.");
        final Integer findFirst2 = ints.parallelStream().findFirst().orElseGet(() -> -1);
        System.out.println("findFirst2 = " + findFirst2);


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
        System.out.println("\nforEach for parallel stream");
        System.out.println("================");
        final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        numbers.parallelStream().forEach(System.out::print);
        System.out.println("\nforEachOrdered for parallel stream");
        System.out.println("=========");
        numbers.parallelStream().forEachOrdered(System.out::print);

        System.out.println("\nUsing intermediate map operation on parallelStream");
        Stream.of("kangaroo", "jackal", "lemur").parallel().map(s -> {System.out.println(s); return s.toUpperCase();}).forEach(System.out::println);

    }

}
