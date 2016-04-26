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

    }

    private static void addSound(List<? extends Object> list) {
        // uncomment the following and java won't compile
        // even in the case of List<?> the code bellow won't compile
        // list.add("quack");
    }


}
