package ro.jtonic.cert.ocp8.ch7;

import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.function.*;

/**
 * Created by antonelpazargic on 25/05/16.
 */
public class SheepManager {

    private AtomicInteger sheepCount = new AtomicInteger(0);

    private int sheepCount1;

    private void incrementAndReport() {
        System.out.print((sheepCount.incrementAndGet()) + " ");
    }

    private void syncIncrementAndReport1() {
        synchronized(this) {
            System.out.print(++sheepCount1 + " ");
        }
    }

    private synchronized void syncIncrementAndReport2() {
        System.out.print(++sheepCount1 + " ");
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
                // service.submit(() -> manager.updateAndReport(e -> ++e));
                // service.submit(() -> manager.syncIncrementAndReport1());
                service.submit(() -> manager.syncIncrementAndReport2());
            }
        } finally {
            if(service != null) {
                service.shutdown();
            }
        }
    }

}
