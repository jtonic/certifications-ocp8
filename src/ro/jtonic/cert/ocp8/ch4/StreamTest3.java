package ro.jtonic.cert.ocp8.ch4;

import java.util.stream.*;
import java.util.*;

/**
 * Created by antonelpazargic on 07/05/16.
 */
public class StreamTest3 {

    public static void main(String... args) {
        List<String> strs = Arrays.asList("w", "o", "l", "f");
        final Stream<String> s1 = strs.stream();
        StringBuilder sb = s1.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
        System.out.println(sb);

        TreeSet<String> ts = strs.stream().collect(Collectors.toCollection(TreeSet::new));
        System.out.println(ts);

        Set<String> set = strs.stream().collect(Collectors.toSet());
        System.out.println(set);

        List<String> lst = strs.stream().collect(Collectors.toList());
        System.out.println(lst);
    }

}
