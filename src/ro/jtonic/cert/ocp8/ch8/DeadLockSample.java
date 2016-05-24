package ro.jtonic.cert.ocp8.ch8;

import java.util.*;
import java.util.concurrent.*;
/**
 * Created by antonelpazargic on 24/05/16.
 */
public class DeadLockSample {

    private static class Food {}
    private static class Water {}

    private static class Fox {

        private String name;

        private Fox(String name) {
            this.name = name;
        }

        private void eatAndDrink(Food food, Water water) {
            synchronized(food) {
                System.out.printf("The %s got the food%n", this.name);
                move();
                synchronized(water) {
                    System.out.printf("The %s got the water%n", this.name);
                }
            }
        }

        private void drinkAndEat(Food food, Water water) {
            synchronized(water) {
                System.out.printf("The %s got the water%n", this.name);
                move();
                synchronized(food) {
                    System.out.printf("The %s got the food%n", this.name);
                }
            }
        }

        private void move() {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch(InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String... args) {
        Food food = new Food();
        Water water = new Water();

        Fox fox1 = new Fox("fox 1");
        Fox fox2 = new Fox("fox 2");

        ExecutorService es = null;
        try{
            es = Executors.newFixedThreadPool(4);
            es.submit(() -> fox1.eatAndDrink(food, water));
            es.submit(() -> fox2.drinkAndEat(food, water));
        } finally {
            if (es != null && !es.isShutdown()) {
                es.shutdown();
            }
        }
    }

}
