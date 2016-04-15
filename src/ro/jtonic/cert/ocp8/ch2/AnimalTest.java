package ro.jtonic.cert.ocp8.ch2;

import java.util.*;

/**
 * Created by antonelpazargic on 15/04/16.
 */
public class AnimalTest {

    public static void main(String... args) {
        Animal a = new Animal("pig", 1, Arrays.asList("meat", "bread"));
        System.out.println(a.getSpecies());
        System.out.println(a.getAge());
        System.out.println(a.getFavoriteFoodsCount());
        System.out.println(a.getFavoriteFood(0));
    }
}
