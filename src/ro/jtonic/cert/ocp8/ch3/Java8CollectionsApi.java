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
        System.out.println("After putIfAbsent: " + favorites);

//        ===================
        favorites.clear();
        favorites.put("Jenny", "Bus Tour");
        favorites.put("Tom", "Tram");
        favorites.put("Sam", null);

        BiFunction<String, String, String> mapper = (v1, v2) -> v1.length() > v2.length() ? v1 : v2;
        System.out.println(favorites.merge("Jenny", "Skyride", mapper));
        System.out.println(favorites.merge("Tom", "Skyride", mapper));
        System.out.println(favorites.merge("Sam", "Skyride", mapper));
        favorites.merge("Dale", "Skyride", mapper);
        System.out.println("After merge: " + favorites);

        // merge example with a BiFunction that returns null
        favorites.clear();
        favorites.put("Jenny", "Bus Tour");
        favorites.put("Tom", null);
        BiFunction<String, String, String> mapper1 = (v1, v2) -> null;
        favorites.merge("Madonna", "La Isla Bonnita", mapper1);
        favorites.merge("Jenny", "New Jenny", mapper1);
        favorites.merge("Tom", "Meow", mapper1);
        System.out.println("Merge with a mapper that returns null: " + favorites);

        // computeIfPresent
        Map<String, Integer> counts = new HashMap<>();
        counts.put("Jenny", 1);
        counts.put("Tom", null);

        BiFunction<String, Integer, Integer> mapper2 = (k, v) -> v + 1;
        final Integer jenny = counts.computeIfPresent("Jenny", mapper2);
        final Integer sam = counts.computeIfPresent("Sam", mapper2);
        final Integer tom = counts.computeIfPresent("Tom", mapper2);
        System.out.println("jenny = " + jenny);
        System.out.println("sam = " + sam);
        System.out.println("tom = " + tom);
        System.out.println("counts = " + counts);



    }
}
