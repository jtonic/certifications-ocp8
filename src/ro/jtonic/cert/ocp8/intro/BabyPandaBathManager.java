package ro.jtonic.cert.ocp8.intro;

import java.util.concurrent.*;
import java.util.stream.*;
/**
 * Created by antonelpazargic on 04/04/16.
 */
public class BabyPandaBathManager {


    public static void main(String[] args) {
        final CyclicBarrier cb = new CyclicBarrier(3, () -> System.out.println("Clean!"));
        ExecutorService service = Executors.newScheduledThreadPool(2);
        IntStream.iterate(1, i -> 1)
                .limit(12)
                .forEach(i -> service.submit(
                        () -> await(cb)
                ));
        service.shutdown();
    }

    public static void await(CyclicBarrier cb) {
        try {
            cb.await();
        } catch(InterruptedException | BrokenBarrierException e) {
            // handle exception
        }
    }

}
