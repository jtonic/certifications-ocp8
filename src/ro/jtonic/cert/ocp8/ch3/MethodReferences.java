package ro.jtonic.cert.ocp8.ch3;

import ro.jtonic.cert.ocp8.Duck;
import java.util.*;
import java.util.function.*;

/**
 * Created by antonelpazargic on 25/04/16.
 */
public class MethodReferences {

    private static class DuckHelper {
        public static int compareByWeight(Duck duck1, Duck duck2) {
            return duck1.getWeight() - duck2.getWeight();
        }
        public static int compareByName(Duck duck1, Duck duck2) {
            return duck1.getName().compareTo(duck2.getName());
        }
    }

    public static void main(String... args) {
        final List<Duck> ducks = Arrays.asList(new Duck("Duck 1", 20), new Duck("Duck 2", 10));
        Comparator<Duck> byWeight = (d1, d2) -> DuckHelper.compareByWeight(d1, d2);
        Collections.sort(ducks, byWeight);
        System.out.println("Ducks compared by weight: " + ducks);

        Collections.sort(ducks, DuckHelper::compareByName);
        System.out.println("Ducks compared by name (using method references): " + ducks);

        String str = "abcd";
        Predicate<String> methRef1 = str::startsWith;

        List<String> strs = new ArrayList<>();
        strs.add("abc");
        strs.add("xyz");
        strs.add("");
        System.out.println("[before] strs:" + strs);

        final boolean two = strs.removeIf(String::isEmpty);
        final boolean one = strs.removeIf(methRef1);
        final boolean three = strs.removeIf(s -> s.startsWith("xy"));
        System.out.println("one = " + one);
        System.out.println("two = " + two);
        System.out.println("three = " + three);
        System.out.println("strs " + strs);
        System.out.println("strs.size() = " + strs.size());

        final List<Integer> ints = Arrays.asList(1, 2, 3, 4);
        System.out.println("[before] ints = " + ints);
        ints.replaceAll(i -> i * 2);
        System.out.println("[after] ints = " + ints);

        ints.forEach(System.out::println);
    }



}
