package ro.jtonic.cert.ocp8.ch3.collection;

import java.util.*;

/**
 * Created by antonelpazargic on 29/04/16.
 */
public class Ch3Test8 {

    public static void main(String... args) {
        NavigableSet<String> strs = new TreeSet<>();
        strs.add("one");
        strs.add("One");
        strs.add("ONE");
        System.out.println(strs.ceiling("On"));
    }

}
