package ro.jtonic.cert.ocp8.ch3.collection;

import java.util.*;
/**
 *
 * Created by antonelpazargic on 28/04/16.
 */
public class ComparingTest {

    private static class Animal {
        private String name;

        public Animal(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return this.name;
        }
    }

    public static void main(String... args) {
        List<String> animals1 = Arrays.asList("lion", "koala", "giraffe");
        Collections.sort(animals1);
        animals1.forEach(System.out::println);

        Set<Animal> animalsSet = new TreeSet<>();
        animalsSet.add(new Animal("giraffe"));

        List<Animal> animals2 = Arrays.asList(new Animal("lion"));
        Collections.sort(animals2);
    }


}
