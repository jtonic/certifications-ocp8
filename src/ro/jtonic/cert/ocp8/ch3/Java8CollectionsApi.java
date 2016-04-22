package ro.jtonic.cert.ocp8.ch3;

import java.util.*;

/**
 * Created by antonelpazargic on 22/04/16.
 */
public class Java8CollectionsApi {

    public static void main(String... args) {
        Map<String, String> favorites  = new HashMap<>();
        favorites.put("Jenny", "Bus Tour");
        System.out.println(favorites);

        favorites.put("Jenny", "Tram");
        System.out.println(favorites);

    }
}
