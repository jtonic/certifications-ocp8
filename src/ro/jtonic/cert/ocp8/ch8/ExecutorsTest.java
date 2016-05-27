package ro.jtonic.cert.ocp8.ch8;

import java.util.*;
import java.util.concurrent.*;
/**
 * Created by antonelpazargic on 27/05/16.
 */
public class ExecutorsTest {

    public static void main(String... args) {
        ExecutorService service = null;
        try {
            service = Executors.newCachedThreadPool();

            service.submit(new Callable<String>() {
                @Override
                public String call() {
                    return "Task 1000";
                }
            });

            System.out.println("Begin");
            List<Callable<String>> tasks = Collections.unmodifiableList(Arrays.asList(
                    new Callable<String>() {
                        @Override
                        public String call() {
                            return "Task 1000";
                        }
                    },
                    (Callable)() -> {
                        System.out.println("Task 1");
                        return "task 1";
                    },
                    () -> {
                        System.out.println("Task 2");
                        return "task 2";
                    },
                    () -> {
                        System.out.println("Task 3");
                        return "task 3";
                    },
                    () -> {
                        for(int i = 0; i < 10000; i++) {
                            System.out.print(".");
                            // hang in here
                        }
                        return "task 4";
                    }
            ));
            List<Future<String>> executedTasks = service.invokeAll(tasks);
            System.out.println("executedTasks.size()= " + executedTasks.size());

            executedTasks.forEach(t -> System.out.println(t.isDone()));
            System.out.println("End");
        } catch (java.lang.InterruptedException e) {
            System.out.println("An interrupted exception has been thrown. message is: " + e.getMessage());
            throw new RuntimeException(e);
        } finally {
            if (service != null) {
                service.shutdown();
            }
        }
    }

}
