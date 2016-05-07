package ro.jtonic.cert.ocp8.ch4;

import java.util.*;
import java.util.stream.*;

/**
 * Created by antonelpazargic on 07/05/16.
 */
public class StreamTest4 {

    public static void main(String... args) {
        List<String> animals = Arrays.asList("monkey", "lion", "tiger");
        animals.stream().filter(a -> a.startsWith("l")).forEach(System.out::println);
    }

}
