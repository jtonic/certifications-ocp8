package ro.jtonic.cert.ocp8.ch7;

import java.util.concurrent.*;

/**
 * Created by antonelpazargic on 27/05/16.
 */
public class ZooInfo {

    public static void main(String... args) throws java.lang.InterruptedException {
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
                boolean serviceTerminated = service.awaitTermination(1, TimeUnit.MINUTES);
                if (serviceTerminated) {
                    System.out.println("All tasks are finished.");
                } else {
                    System.out.println("At least one task is still running...");
                }
                // List<Runnable> unfinishedTasks = service.shutdownNow();
                // System.out.println("unfinishedTasks.size() = " + unfinishedTasks.size());

                System.out.println("checking the isShutdown and isTerminated on the executor service...");
                System.out.println("service.isShutdown() = " + service.isShutdown());
                System.out.println("service.isTerminated() = " + service.isTerminated());

                // trying to submit a new task after shutting down the executor service throws java.util.concurrent.RejectedExecutionException
                service.submit(() -> System.out.println("A task submitted after shutting down the executor service..."));
            }
        }
    }

}
