package ro.jtonic.cert.ocp8.ch8;

import java.util.concurrent.*;
import java.util.*;

/**
 * Created by antonelpazargic on 24/05/16.
 */
public class CyclicBarrierTest {

    private static class LionPenManager {
        private void removeAnimals() {
            System.out.println("Removing animals...");
        }

        private void cleanPens() {
            System.out.println("Cleaning the pens...");
        }

        private void addAnimals() {
            System.out.println("Adding animals....");
        }

        private void performTask(CyclicBarrier cb1, CyclicBarrier cb2) {
            try {
                removeAnimals();
                cb1.await();
                cleanPens();
                cb2.await();
                addAnimals();
            } catch(InterruptedException | BrokenBarrierException e) {
                // pass the problem to the caller
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String... args) {
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(10);

            LionPenManager m = new LionPenManager();

            final CyclicBarrier cb1 = new CyclicBarrier(10, () -> System.out.println("The animals have been removed."));
            final CyclicBarrier cb2 = new CyclicBarrier(10, () -> System.out.println("The pens have been cleaned."));

            for (int i = 0; i < 10; i++) {
                service.submit(() -> {
                    m.performTask(cb1, cb2);
                });
            }
        } finally {
            if (service != null && !service.isShutdown()) {
                service.shutdown();
            }
        }

    }

}
