package ro.jtonic.cert.ocp8.ch4;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

/**
 * Created by antonelpazargic on 06/05/16.
 */
public class StreamTest1 {

    public static void main(String... args) {
        final long c1 = Stream.<String>empty().count();
        System.out.println("c1 = " + c1);

        final Stream<Integer> s0 = Stream.of(1, 2, 3);
        System.out.println("stream: " + s0);

        final boolean allMatch = s0.allMatch(i -> i > 0);
        System.out.println("allMatch = " + allMatch);

        final boolean noneMatch = Stream.of(-1, -2, -3).noneMatch(i -> i >= 0);
        System.out.println("noneMatch = " + noneMatch);

        Arrays.asList(1, 2, 3, 4, 5).stream().filter(i -> i % 2 == 0).forEach(System.out::println);

        System.out.println("Stream#anyMatch can transform an infinite stream into a finite one");
        Stream.iterate(1, i -> i + 1).peek(System.out::println).anyMatch(i -> i >= 2);

        Stream.generate(Math::random).findFirst().ifPresent(d -> System.out.println("First element = " + d));
        final Integer in = Stream.iterate(1, i -> i + 1).findAny().orElse(-1);
        System.out.println("findAny: " + in);

        final List<Integer> collector1 = Arrays.asList(1, 2, 3, 4, 5).stream().collect(Collectors.toList());
        System.out.println("collector1 = " + collector1);

        // Stream.iterate(1, i -> i + 2).forEach(System.out::println); // this hangs since it is an infinite stream.
        //
        // final Stream<Double> s1 = Stream.generate(Math::random);
        // s1.forEach(System.out::println); //this hangs because s1 is an infinite stream



    }

}
