package ro.jtonic.cert.ocp8.ch8;

import java.util.*;
import java.util.concurrent.*;

/**
 * Created by antonelpazargic on 24/05/16.
 */
public class ForkJoinTest1 {

    private static class WeightAnimalAction extends RecursiveAction {

        private Double[] weights;
        private int start;
        private int end;

        private WeightAnimalAction(Double[] weights, int start, int end) {
            this.weights = weights;
            this.start = start;
            this.end = end;
        }

        @Override
        protected void compute() {
            if (this.end - this.start <= 3) {
                for (int i = start; i < end; i++) {
                    weights[i] = (double) new Random().nextInt(100);
                    System.out.println("Animal weighted: " + weights[i]);
                }
            } else {
                int middle = start + (end - start) / 2;
                System.out.println("start= " + this.start + "; middle= " + middle + "; end= " + this.end);
                invokeAll(new WeightAnimalAction(this.weights, this.start, middle), new WeightAnimalAction(this.weights, middle, this.end));
            }

        }
    }

    public static void main(String... args) {
        Double[] weights = new Double[10];
        ForkJoinTask<?> task = new WeightAnimalAction(weights, 0, weights.length);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(task);
        Arrays.asList(weights).stream().forEach(d -> System.out.print(d.intValue() + " "));
    }

}
