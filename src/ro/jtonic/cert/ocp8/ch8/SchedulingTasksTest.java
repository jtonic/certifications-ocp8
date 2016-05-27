package ro.jtonic.cert.ocp8.ch8;

import java.util.concurrent.*;
/**
 * Created by antonelpazargic on 27/05/16.
 */
public class SchedulingTasksTest {

    public static void main(String... arfs) throws java.lang.InterruptedException, java.util.concurrent.ExecutionException {
        ScheduledExecutorService scheduledService = null;
        try {
            System.out.println("Begin");
            scheduledService = Executors.newSingleThreadScheduledExecutor();
            ScheduledFuture<?> future = scheduledService.schedule(
                    () -> {
                        System.out.println("Executed after a specified time interval.");
                    }
                    , 4, TimeUnit.SECONDS);
            TimeUnit.SECONDS.sleep(5);
            System.out.println("Future's delay: " + future.getDelay(TimeUnit.SECONDS));

            Object result = future.get();
            System.out.println("Result: " + result);
            System.out.println("End");
        } finally {
            if (scheduledService != null) {
                scheduledService.shutdown();
            }
        }
    }

}
