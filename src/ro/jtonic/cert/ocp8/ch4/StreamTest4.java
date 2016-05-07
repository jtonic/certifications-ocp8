package ro.jtonic.cert.ocp8.ch4;

import java.util.*;
import java.util.stream.*;

/**
 * Created by antonelpazargic on 07/05/16.
 */
public class StreamTest4 {

    public static void main(String... args) {
        List<String> animals = Arrays.asList("monkey", "lion", "tiger");
        animals.stream().filter(a -> a.startsWith("l")).forEach(System.out::println);

        animals = Arrays.asList("goose", "duck", "duck", "goose", "chicken");
        animals.stream().distinct().forEach(System.out::print);

        Stream.iterate(1, i -> i + 1).limit(5).forEach(System.out::println);
        Stream.iterate(1, i -> i + 1).skip(5).limit(5).forEach(System.out::print);

        System.out.println("======");
        Stream.of("Gorilla", "Monkey", "Snake", "Lion", "Tiger", "Giraffe").map(String::length).forEach(System.out::print);
    }

}
