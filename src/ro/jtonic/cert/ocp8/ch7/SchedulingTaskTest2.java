package ro.jtonic.cert.ocp8.ch7;

import java.util.concurrent.*;

/**
 * Created by antonelpazargic on 27/05/16.
 */
public class SchedulingTaskTest2 {

    public static void main(String... args) throws java.lang.InterruptedException {

        System.out.println("Available processors: " + java.lang.Runtime.getRuntime().availableProcessors());
        System.exit(0);

        ScheduledExecutorService scheduledService = null;
        try {
            System.out.println("Begin.");
            scheduledService = Executors.newSingleThreadScheduledExecutor();
            ScheduledFuture<?> future = scheduledService.scheduleWithFixedDelay(() -> {
                System.out.println("Executed periodically at/with fixed rate/delay.");
            }, 3, 5,TimeUnit.SECONDS);
            TimeUnit.SECONDS.sleep(5);
            System.out.println("future.getDelay(TimeUnit.SECONDS) = " + future.getDelay(TimeUnit.SECONDS));
            TimeUnit.SECONDS.sleep(5);
            System.out.println("End.");
        } finally {
            if (scheduledService != null) {
                scheduledService.shutdown();  // comment this out in order to have a never ending regular execution of the scheduled task
            }
        }
    }

}
