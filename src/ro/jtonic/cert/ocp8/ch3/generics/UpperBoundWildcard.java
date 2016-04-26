package ro.jtonic.cert.ocp8.ch3.generics;

import java.util.*;

/**
 * Created by antonelpazargic on 26/04/16.
 */
public class UpperBoundWildcard {

    static class Sparrow extends Bird { }

    static class Bird { }

    public static void main(String... args) {
        List<? extends Bird> birds = new ArrayList<>();
        birds.add(new Sparrow());
        birds.add(new Bird());
    }

}
