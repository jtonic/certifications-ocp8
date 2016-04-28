package ro.jtonic.cert.ocp8.ch3.collection;

import java.util.*;

/**
 * Created by antonelpazargic on 28/04/16.
 */
public class QueueTest {

    public static void main(String... args) {
        Queue<Integer> queue = new ArrayDeque<>();
        System.out.println(queue.offer(10));
        System.out.println(queue.offer(4));
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.peek());
    }
}
