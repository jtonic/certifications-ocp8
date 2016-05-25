package ro.jtonic.cert.ocp8.ch8;

import java.util.concurrent.*;
import java.util.*;
/**
 *
 * Created by antonelpazargic on 25/05/16.
 */
public class ConcurrentCollectionsTest {

    private static class ZooManager {
        private Map<String, String> foodData = new ConcurrentHashMap<>();

        private void put(String key, String food) {
            this.foodData.put(key, food);
        }

        private String get(String key) {
            return this.foodData.get(key);
        }
    }

    public static void main(String... args) {
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(10);
            ZooManager manager = new ZooManager();
            for(int i = 0; i < 100; i++) {
                int j = i;
                service.submit(() -> manager.put("key " + j, "food " + j));
            }
            manager.foodData.forEach((k, v) -> System.out.println(k + ", " + v));
        } finally {
            if (service != null) {
                service.shutdown();
            }
        }

        // Removing entries from a ConcurrentHashMap during iteration over its entries
        System.out.println("===========================================================================");
        System.out.println("Removing entries from a ConcurrentHashMap during iteration over its entries");
        System.out.println("===========================================================================");
        Map<String, Integer> animalFood1 = new ConcurrentHashMap<>();
        animalFood1.put("fox", 1);
        animalFood1.put("elephant", 20);
        animalFood1.put("koala", 2);
        for(String k: animalFood1.keySet()) {
            animalFood1.remove(k);
        }
        System.out.println(animalFood1.size());
        animalFood1.forEach((k, v) -> System.out.println(k + ", " + v));

        // Removing entries from a reqular map during iteration over its entries
        System.out.println("===========================================================================");
        System.out.println("Removing entries from a reqular map during iteration over its entries. Throws java.util.ConcurrentModificationException");
        System.out.println("===========================================================================");
        Map<String, Integer> animalFood = new HashMap<>();
        animalFood.put("penguin", 1);
        animalFood.put("lion", 10);
        animalFood.put("dear", 3);
        for(String key: animalFood.keySet()) {
            animalFood.remove(key); // java.util.ConcurrentModificationException
        }

    }

}
