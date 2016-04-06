package ro.jtonic.cert.ocp8.intro;

/**
 * Created by antonelpazargic on 06/04/16.
 */

import java.time.LocalDate;
import java.util.stream.Stream;
import java.util.function.UnaryOperator;

public class Test20 {

    public static void main(String[] args) {
        Stream<LocalDate> s = Stream.of(LocalDate.now());
        UnaryOperator<LocalDate> u = l -> l;
        final Stream<LocalDate> peek = s.filter(l -> l != null).map(u).peek(System.out::println);
//        peek.forEach(System.out::println);
    }

}
