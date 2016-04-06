package ro.jtonic.cert.ocp8.intro;

import java.util.stream.*;
import java.util.Optional;
/**
 * Created by antonelpazargic on 05/04/16.
 */
public class Test11 {

    private static void magic(Stream<Integer> s) {
        Optional o = s.filter(x -> x < 5).limit(3).max((x, y) -> x - y);
        System.out.println(o.get());
    }

    public static void main(String[] args) {
        magic(Stream.empty());
        magic(Stream.iterate(1, x -> x++));
        magic(Stream.of(5, 10));
    }

}
