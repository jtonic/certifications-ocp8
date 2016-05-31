package ro.jtonic.cert.ocp8.ch7;

import java.util.*;
import java.util.concurrent.*;

/**
 * Created by antonelpazargic on 26/05/16.
 */
public class CollectionsTest {

    public static void main(String... args) {
        List<Integer> lst1 = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> concLst1 = Collections.synchronizedList(lst1);
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(10);
            service.submit(() -> {
                synchronized(concLst1) {
                    concLst1.forEach(System.out::print);
                }
            }); // the iterator is not synchronized. It should be synchronized by the user
            for(int i = 0; i < 100; i++) {
                service.submit(() -> concLst1.add(new Random().nextInt(100)));
            }
            service.submit(() -> {
                synchronized(concLst1) {
                    concLst1.forEach(System.out::println);
                }
            });
        } finally {
            if (service != null && !service.isShutdown()) service.shutdown();
        }
    }
}


