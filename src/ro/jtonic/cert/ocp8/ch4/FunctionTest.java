package ro.jtonic.cert.ocp8.ch4;

import java.util.*;
import java.util.function.*;

/**
 * Created by antonelpazargic on 04/05/16.
 */
public class FunctionTest {

    public static void main(String... args) {
        Function<String, String> toUpper = String::toUpperCase;
        System.out.println(toUpper.apply("jtonic"));

        Function<String, Integer> lettersCount = String::length;
        System.out.println(lettersCount.apply("Antonel"));

        System.out.println(lettersCount.andThen(i -> i % 2).apply("jtonic"));

        BiFunction<String, String, String> concat = String::concat;
        System.out.println(concat.apply("Antonel ", "Pazargic"));
    }

}
