package ro.jtonic.cert.ocp8.ch4;

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
            // empty.get();
        }

        empty.ifPresent(System.out::println);

        System.out.println(empty.orElse("n/a"));
        System.out.println(empty.orElseGet(() -> "not available"));

        Optional<Double> o2 = Optional.empty();
        final Double no = o2.orElse(Double.NaN);
        System.out.println(no);

        // display the number that are three digits
        printIfThreeDigitsNumber(Optional.of(100));
        printIfThreeDigitsNumber(Optional.of(1));
        printIfThreeDigitsNumber(Optional.empty());

        System.out.println(getNumberOfCharacters(Optional.of("jtonic")));
        System.out.println(getNumberOfCharacters(Optional.empty()));

        empty.orElseThrow(() -> new RuntimeException("The optional is empty"));
    }

    private static Integer getNumberOfCharacters(Optional<String> o3) {
        return o3.map(OptionalTest::calculator).orElse(-1);
//        return o3.map(String::length).orElse(-1);
    }

    private static <T> void printIfThreeDigitsNumber(Optional<T> opt) {
        System.out.println(opt.map(i -> "" + i).filter(s -> s.length() == 3).orElse("none"));
    }

    private static Integer calculator(String s) {
        System.out.println("=====calculator======");
        return s.length();
    }
}
