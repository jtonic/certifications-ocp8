package ro.jtonic.cert.ocp8.ch3.collection;

import java.util.*;

/**
 * Created by antonelpazargic on 27/04/16.
 */
public class HashSetTest {

    public static void main(String... args) {
        Set<Integer> ints = new HashSet<>();
        System.out.println(ints.add(10));
        System.out.println(ints.add(-1));
        System.out.println(ints.add(100));
        System.out.println(ints.add(10));

        for(Integer in: ints) {
            System.out.println(in);
        }

    }

}
