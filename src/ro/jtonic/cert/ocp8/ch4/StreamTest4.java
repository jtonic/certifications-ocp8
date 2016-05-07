package ro.jtonic.cert.ocp8.ch4;

import java.util.*;
import java.util.stream.*;

/**
 * Created by antonelpazargic on 07/05/16.
 */
public class StreamTest4 {

    public static void main(String... args) {
        List<String> animals1 = Arrays.asList("monkey", "lion", "tiger");
        animals1.stream().filter(a -> a.startsWith("l")).forEach(System.out::println);

        animals1 = Arrays.asList("goose", "duck", "duck", "goose", "chicken");
        animals1.stream().distinct().forEach(System.out::print);

        Stream.iterate(1, i -> i + 1).limit(5).forEach(System.out::println);
        Stream.iterate(1, i -> i + 1).skip(5).limit(5).forEach(System.out::print);

        System.out.println("\n======");
        final String[] animals2 = {"Gorilla", "Monkey", "Snake", "Lion", "Tiger", "Giraffe"};
        Stream.of(animals2).map(String::length).forEach(System.out::print);

        List<Integer> l1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> l2 = new ArrayList<>();
        List<Integer> l3 = Arrays.asList(4, 5, 6, 7);
        System.out.println("\n========");
        Stream.of(l1, l2, l3).flatMap(Collection::stream).forEach(System.out::println);

        System.out.println("\n=========");
        Stream.of(animals2).sorted().forEach(System.out::println);
        System.out.println("\n=========");
        Stream.of(animals2).sorted(Comparator.reverseOrder()).forEach(System.out::println);

        System.out.println("\nBears whos name starts with b");
        String[] bears = {"black bear", "brown bear", "grizzly"};
        final long count = Stream.of(bears).filter(s -> s.startsWith("b")).peek(System.out::println).count();
        System.out.println("count = " + count);
    }

}
