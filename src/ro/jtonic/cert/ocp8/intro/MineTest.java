package ro.jtonic.cert.ocp8.intro;

/**
 * Created by antonelpazargic on 06/04/16.
 */

import java.util.stream.IntStream;

public class MineTest {

    public static void main(String[] args) {
        IntStream.iterate(1, i -> i + 1)
                .limit(10)
                .forEach(System.out::println);
    }

}
