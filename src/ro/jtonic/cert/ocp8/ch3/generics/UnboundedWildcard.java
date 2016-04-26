package ro.jtonic.cert.ocp8.ch3.generics;

import java.util.*;

/**
 * Created by antonelpazargic on 26/04/16.
 */
public class UnboundedWildcard {

    public static void main(String... args) {
        List<String> keywords = new ArrayList<>();
        keywords.add("java");
        printList(keywords);

        List<Integer> integers = new ArrayList<>();
        integers.add(new Integer(1));
        List<Object> objects = integers;
        objects.add("two");
        System.out.println(objects.get(1));
    }

    private static void printList(List<Object> list) {
        for (Object x: list) System.out.println(x);
    }

}
