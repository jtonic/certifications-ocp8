package ro.jtonic.cert.ocp8.ch3;

import java.util.*;
import java.util.function.*;

/**
 * Created by antonelpazargic on 22/04/16.
 */
public class Java8CollectionsApi {

    public static void main(String... args) {
        Map<String, String> favorites  = new HashMap<>();
        favorites.put("Jenny", "Bus Tour");
        favorites.put("Tom", null);
        System.out.println(favorites);

        favorites.putIfAbsent("Jenny", "Tram");
        favorites.putIfAbsent("Sam", "Tram");
        favorites.putIfAbsent("Tom", "Tram");
        System.out.println(favorites);

//        ===================
        favorites.clear();
        favorites.put("Jenny", "Bus Tour");
        favorites.put("Tom", "Tram");

        BiFunction<String, String, String> mapper = (v1, v2) -> v1.length() > v2.length() ? v1 : v2;
        System.out.println(favorites.merge("Jenny", "Skyride", mapper));
        System.out.println(favorites.merge("Tom", "Skyride", mapper));
        System.out.println(favorites);
    }
}
