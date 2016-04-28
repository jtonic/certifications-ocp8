package ro.jtonic.cert.ocp8.ch3.collection;

import java.util.*;

/**
 * Created by antonelpazargic on 28/04/16.
 */
public class LinkedListTest {

    public static void main(String... args) {
        System.out.println("LinkedList as a queue.");
        Queue<Integer> queue = new LinkedList<>();
        System.out.println(queue.offer(10));
        System.out.println(queue.offer(4));
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.peek());

        System.out.println("LinkedList as a stack.");
        Deque<Integer> stack = new LinkedList<>();
        stack.push(10);
        stack.push(4);
        System.out.println(stack.peek());
        System.out.println(stack.poll());
        System.out.println(stack.poll());
        System.out.println(stack.peek());
    }

}
