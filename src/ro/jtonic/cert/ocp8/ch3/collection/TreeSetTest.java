package ro.jtonic.cert.ocp8.ch3.collection;

import java.util.*;

/**
 * Created by antonelpazargic on 27/04/16.
 */
public class TreeSetTest {


    public static void main(String... args) {
        final NavigableSet<Integer> ints = new TreeSet<>();
        for(int i = 1; i <= 20; i++) {
            ints.add(i);
        }

        System.out.println("ints = " + ints);

        System.out.println(ints.lower(10));
        System.out.println(ints.higher(19));

        System.out.println(ints.floor(10));
        System.out.println(ints.ceiling(19));

        System.out.println(ints.higher(20));
    }
}
