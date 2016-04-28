package ro.jtonic.cert.ocp8.ch3.collection;

import java.util.*;

/**
 * Created by antonelpazargic on 28/04/16.
 */
public class MapTest {

    public static void main(String... args) {

        System.out.println("A simple example with HashMap.");
        Map<String, String> map = new HashMap<>();
        System.out.println(map.put("koala", "bamboo"));
        System.out.println(map.put("lion", "meat"));
        System.out.println(map.put("giraffe", "leaf"));
        System.out.println(map.put("giraffe", "grass"));
        String food = map.get("koala");
        System.out.println(food);
        for (String key : map.keySet()) {
            System.out.print(key + ", ");
        }

        System.out.println("\nA simple example with treeMap");
        map = new TreeMap<>();
        map.put("koala", "bamboo");
        map.put("lion", "meat");
        map.put("giraffe", "leaf");
        food = map.get("lion");
        System.out.println(food);
        for(String key: map.keySet()) {
            System.out.print(key + ", ");
        }
        System.out.println();

        System.out.println(map.containsKey("koala"));
        System.out.println(map.containsKey("tiger"));

        System.out.println(map.containsValue("bamboo"));
        System.out.println(map.containsValue("bread"));

        for (String value: map.values()) {
            System.out.print(value + ", ");
        }
        System.out.println();
    }

}
