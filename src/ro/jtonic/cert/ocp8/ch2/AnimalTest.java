package ro.jtonic.cert.ocp8.ch2;

import ro.jtonic.cert.ocp8.ch2.pkg.Animal;
import ro.jtonic.cert.ocp8.ch2.pkg.AnimalBuilder;

import java.util.*;

/**
 * Created by antonelpazargic on 15/04/16.
 */
public class AnimalTest {

    public static void main(String... args) {
        Animal a = new AnimalBuilder()
                .setSpecies("pig")
                .setAge(1)
                .setFavoriteFoods(Arrays.asList("meat", "bread"))
                .build();
        System.out.println(a.getSpecies());
        System.out.println(a.getAge());
        System.out.println(a.getFavoriteFoodsCount());
        System.out.println(a.getFavoriteFood(0));
    }
}
