package ro.jtonic.cert.ocp8.ch4;

import java.util.*;
import java.util.function.*;

/**
 * Created by antonelpazargic on 04/05/16.
 */
public class PredicateTest {

    public static void main(String... args) {
        Predicate<Collection<?>> isEmpty1 = Collection::isEmpty;
        Predicate<Collection<?>> isEmpty2 = col -> col.isEmpty();

        final ArrayList<Object> a1 = new ArrayList<>();
        final List<Integer> a2 = Arrays.asList(1, 2, 3);

        System.out.println(isEmpty1.test(a1));
        System.out.println(isEmpty1.test(a2));

        System.out.println("isEmpty2.test(a1) = " + isEmpty2.test(a1));
        System.out.println("isEmpty2.test(a2) = " + isEmpty2.test(a2));


        Predicate<String> p1 = String::isEmpty;
        Predicate<String> p2 = s -> s.isEmpty();
        System.out.println(p1.test(""));
        System.out.println(p2.test("jtonic"));

        String str = "jtonic and tutye";
        System.out.println(p1.negate().test("jtonic"));

        Predicate<String> p3 = s1 -> s1.startsWith("jtonic");
        Predicate<String> p4 = s1 -> s1.endsWith("tutye");

        System.out.println(p3.and(p4).test(str));

        BiPredicate<String, String> p5 = String::startsWith;
        System.out.println(p5.test("jtonic", "jt"));
    }

}
