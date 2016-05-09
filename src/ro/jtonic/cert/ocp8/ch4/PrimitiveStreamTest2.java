package ro.jtonic.cert.ocp8.ch4;

import java.util.function.*;
import java.util.*;
import java.util.stream.*;

/**
 * Created by antonelpazargic on 08/05/16.
 */
public class PrimitiveStreamTest2 {

    public static void main(String... args) {
        BooleanSupplier bs = () -> true;
        System.out.println(bs.getAsBoolean());

        IntSupplier is = () -> Math.random() >= 0.5? 1: 0;
        System.out.println(is.getAsInt());

        LongConsumer lc1 = l -> System.out.println(l);
        LongConsumer lc2 = System.out::println;
        lc1.accept(100);
        lc2.accept(200);

        DoublePredicate dp1 = d -> d < 1;
        System.out.println(dp1.test(0));
        System.out.println(dp1.test(10));

        IntFunction<String> if1 = Integer::toString;
        System.out.println("if1: " + if1.apply(300));

        IntBinaryOperator ibo = (i1, i2) -> i1 + i2;
        System.out.println("sum of 1 and 2 = " + ibo.applyAsInt(1, 2));

        IntUnaryOperator uo1 = i1 -> Math.abs(i1);
        IntUnaryOperator uo2 = Math::abs;
        System.out.println("uo1" + uo1.applyAsInt(-1));
        System.out.println("uo2" + uo2.applyAsInt(-2));


        // Streams are lazy evaluated
        List<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(2);
        ints.add(3);
        Stream<Integer> intSt = ints.stream();
        ints.add(4);
        System.out.println("Number of integers in the stream: " + intSt.count());
    }

}
