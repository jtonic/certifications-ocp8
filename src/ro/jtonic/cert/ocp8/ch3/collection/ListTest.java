package ro.jtonic.cert.ocp8.ch3.collection;

import java.util.*;

/**
 * Created by antonelpazargic on 27/04/16.
 */
public class ListTest {

    public static void main(String... args) {
        List<String> lst = new ArrayList<>();
        lst.add("a");
        lst.add(0, "b");
        lst.add(1, "c");
        System.out.println("lst = " + lst);

        Iterator<String> iter = lst.iterator();
        while(iter.hasNext()) {
            String it = iter.next();
            System.out.println(it);
        }

        lst.remove("b");
        lst.remove(0);
        System.out.println("lst = " + lst);
        lst.set(0, "d");
        System.out.println("lst = " + lst);
        String first = lst.get(0);
        System.out.println("first = " + first);

        final int idxOfD = lst.indexOf("d");
        System.out.println("idxOfD = " + idxOfD);

        final int idxOfA = lst.indexOf("a");
        System.out.println("idxOfA = " + idxOfA);

        String doesNotExist = lst.get(1);
        System.out.println("doesNotExist = " + doesNotExist);

    }

}
