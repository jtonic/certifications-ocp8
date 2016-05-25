package ro.jtonic.cert.ocp8.ch8;

import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.function.*;

/**
 * Created by antonelpazargic on 25/05/16.
 */
public class SheepManager {

    private AtomicInteger sheepCount = new AtomicInteger(0);

    private void incrementAndReport() {
        System.out.print((sheepCount.incrementAndGet()) + " ");
    }

    private void addAndReport(int add) {
        System.out.print(sheepCount.addAndGet(add) + " ");
    }

    private void updateAndReport(IntUnaryOperator op) {
        System.out.print(sheepCount.updateAndGet(op) + " ");
    }

    public static void main(String... args) {
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(20);
            SheepManager manager = new SheepManager();
            for(int i = 0; i < 10; i++) {
                // service.submit(() -> manager.incrementAndReport());
                // service.submit(() -> manager.addAndReport(2));
                service.submit(() -> manager.updateAndReport(e -> ++e));
            }
        } finally {
            if(service != null) {
                service.shutdown();
            }
        }
    }

}
