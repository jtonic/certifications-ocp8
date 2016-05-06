package ro.jtonic.cert.ocp8.ch4;

import java.util.stream.*;
import java.util.*;

/**
 * Created by antonelpazargic on 06/05/16.
 */
public class StreamTest2 {

    public static void main(String... args) {
        List<String> lst = Collections.emptyList();
        Optional<String> max = getMax(lst);
        max.ifPresent(System.out::println);

        lst = Arrays.asList("tiger", "leon", "giraffe", "monkey");
        getMax(lst).ifPresent(System.out::println);
        getMin(lst).ifPresent(System.out::println);

    }

    private static Optional<String> getMax(List<String> lst) {
        return lst.stream().max(Comparator.naturalOrder());
    }

    private static Optional<String> getMin(List<String> lst) {
        return lst.stream().max(Comparator.reverseOrder());
    }
}
