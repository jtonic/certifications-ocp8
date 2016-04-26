package ro.jtonic.cert.ocp8.ch3.generics;

import java.util.*;

/**
 * Created by antonelpazargic on 26/04/16.
 */
public class LowerBoundedWildcard {

    public static void main(String... args) {
        List<String> strings = new ArrayList<>();
        strings.add("tweet");
        List<Object> objects = new ArrayList<>(strings);
        addSound(strings);
        addSound(objects);

        strings.forEach(System.out::println);
        objects.forEach(System.out::println);
    }

    private static void addSound(List<? super String> list) {
        list.add("quack");
    }

}
