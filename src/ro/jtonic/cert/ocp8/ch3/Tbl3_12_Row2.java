package ro.jtonic.cert.ocp8.ch3;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Created by antonelpazargic on 25/04/16.
 */
public class Tbl3_12_Row2 {

    public static void main(String... args) {
        //
        Map<String, Integer> counts = new HashMap<>();
        counts.put("merge", null);
        counts.put("computeIfPresent", null);
        counts.put("computeIfAbsent", null);

        BiFunction<Integer, Integer, Integer> mergeMapper = (v1, v2) -> 2;
        BiFunction<String, Integer, Integer> computeIfPresentMapper = (k, v) -> 1;
        Function<String, Integer> computeIfAbsentMapper = k -> 1;

        final Integer merge = counts.merge("merge", 1, mergeMapper);
        final Integer computeIfPresent = counts.computeIfPresent("computeIfPresent", computeIfPresentMapper);
        final Integer computeIfAbsent = counts.computeIfAbsent("computeIfAbsent", computeIfAbsentMapper);
        System.out.println("merge = " + merge);
        System.out.println("computeIfPresent = " + computeIfPresent);
        System.out.println("computeIfAbsent = " + computeIfAbsent);
        System.out.println("count = " + counts);

    }

}
