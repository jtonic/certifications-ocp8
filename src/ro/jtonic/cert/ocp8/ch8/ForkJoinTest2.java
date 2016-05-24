package ro.jtonic.cert.ocp8.ch8;

import java.util.concurrent.*;
import java.util.*;
/**
 * Created by antonelpazargic on 24/05/16.
 */
public class ForkJoinTest2 {

    private static class WeightAnimalTask extends RecursiveTask<Double> {

        private Double[] weights;
        private int start;
        private int end;

        private WeightAnimalTask(Double[] weights, int start, int end) {
            this.weights = weights;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Double compute() {
            if (this.end - this.start <= 3) {
                double sum = 0;
                for(int i = start; i < end; i++) {
                    this.weights[i] = (double) new Random().nextInt(100);
                    System.out.printf("The animal %d wights %d %n", i, this.weights[i].intValue());
                    sum += this.weights[i];
                }
                return sum;
            } else {
                int middle = this.start + (this.end - this.start) / 2;
                System.out.println("start= " + this.start + "; middle= " + middle + "; end= " + this.end);
                RecursiveTask<Double> otherTask = new WeightAnimalTask(this.weights, this.start, middle);
                otherTask.fork();
                return new WeightAnimalTask(this.weights, middle, this.end).compute() + otherTask.join();
            }
        }
    }

    public static void main(String... args) {
        Double[] weights = new Double[10];
        ForkJoinTask<Double> task = new WeightAnimalTask(weights, 0, weights.length);
        ForkJoinPool pool = new ForkJoinPool();
        Double totalWeight = pool.invoke(task);

        Arrays.asList(weights).stream().forEach(e -> System.out.print(e.intValue() + " "));
        System.out.println("\nTotalWeight = " + totalWeight);
    }

}
