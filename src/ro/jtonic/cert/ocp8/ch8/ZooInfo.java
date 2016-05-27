package ro.jtonic.cert.ocp8.ch8;

import java.util.concurrent.*;
/**
 * Created by antonelpazargic on 27/05/16.
 */
public class ZooInfo {

    public static void main(String... args) {
        ExecutorService service = null;
        try {
            System.out.println("begin");
            service = Executors.newSingleThreadExecutor();
            service.execute(() -> System.out.println("Printing zoo inventory..."));
            service.submit(() -> {
                for (int i = 0; i < 1000; i++) {
                    System.out.println(i);
                }
                System.out.println();
            });
            service.submit(() -> System.out.println("Zoo inventory is printed."));
            System.out.println("end");
        } finally {
            if (service != null) {
                service.shutdown();
                // trying to submit a new task after shutting down the executor service throws java.util.concurrent.RejectedExecutionException

                System.out.println("checking the isShutdown and isTerminated on the executor service...");
                System.out.println("service.isShutdown() = " + service.isShutdown());
                System.out.println("service.isTerminated() = " + service.isTerminated());

                service.submit(() -> System.out.println("A task submitted after shutting down the executor service..."));
            }
        }
    }

}
