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

        List<String> chars = Arrays.asList("w", "o", "l", "f");
        final String concat = chars.stream().reduce("", (a, b) -> a + b);
        System.out.println("simple stream reduce to concatenate " + concat);

        System.out.println("Simple stream reduce with no identity version api. the method returns Optional in this case because the stream can be empty");
        chars.stream().reduce(String::concat).ifPresent(System.out::println);
        final String conc2 = Stream.<String>empty().reduce(String::concat).orElse("n/a");
        System.out.println("conc2 = " + conc2);
    }

    private static Optional<String> getMax(List<String> lst) {
        return lst.stream().max(Comparator.naturalOrder());
    }

    private static Optional<String> getMin(List<String> lst) {
        return lst.stream().max(Comparator.reverseOrder());
    }
}
