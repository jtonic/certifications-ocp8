package ro.jtonic.cert.ocp8.ch4;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

/**
 * Created by antonelpazargic on 06/05/16.
 */
public class StreamTest {

    public static void main(String... args) {
        final long c1 = Stream.<String>empty().count();
        System.out.println("c1 = " + c1);

        final boolean allMatch = Stream.of(1, 2, 3).allMatch(i -> i > 0);
        System.out.println("allMatch = " + allMatch);

        final boolean noneMatch = Stream.of(-1, -2, -3).noneMatch(i -> i >= 0);
        System.out.println("noneMatch = " + noneMatch);

        Arrays.asList(1, 2, 3, 4, 5).stream().filter(i -> i % 2 == 0).forEach(System.out::println);
    }

}
