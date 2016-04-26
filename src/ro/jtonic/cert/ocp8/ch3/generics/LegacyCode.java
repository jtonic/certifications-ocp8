package ro.jtonic.cert.ocp8.ch3.generics;

import java.util.*;

/**
 * Created by antonelpazargic on 26/04/16.
 */
public class LegacyCode {

    private static final class Dragon { }

    private static final class Unicorn { }

    public static void main(String... args) {
        List dragons = new ArrayList();
        dragons.add(new Unicorn());
        printDragons(dragons);
    }

    private static void printDragons(List<Dragon> dragons) {
        dragons.forEach(System.out::println);
    }
}
