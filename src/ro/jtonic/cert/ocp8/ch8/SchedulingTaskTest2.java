package ro.jtonic.cert.ocp8.ch8;

import java.util.concurrent.*;
import java.util.*;
/**
 * Created by antonelpazargic on 27/05/16.
 */
public class SchedulingTaskTest2 {

    public static void main(String... args) throws java.lang.InterruptedException {
        ScheduledExecutorService scheduledService = null;
        try {
            System.out.println("Begin.");
            scheduledService = Executors.newSingleThreadScheduledExecutor();
            ScheduledFuture<?> future = scheduledService.scheduleAtFixedRate(() -> {
                System.out.println("Executed periodically at fixed rate.");
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
