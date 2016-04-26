package ro.jtonic.cert.ocp8.ch3.generics;

/**
 * Created by antonelpazargic on 25/04/16.
 */
public class Crate<T> {

    private T contents;

    public T empty() {
        return this.contents;
    }

    public void packCrate(T contents) {
        this.contents = contents;
    }

    static class Elephant {
        private String name;

        public Elephant(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        @Override
        public String toString() {
            return getName();
        }

    }

    static class Zebra {
        private String name;

        public Zebra(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        @Override
        public String toString() {
            return getName();
        }

    }

    public static void main(String... args) {
        Crate<Elephant> crateForElephant = new Crate<>();
        crateForElephant.packCrate(new Elephant("Tiny"));
        System.out.println(crateForElephant.empty());

        Crate<Zebra> crateForZebra = new Crate<>();
        crateForZebra.packCrate(new Zebra("Smally"));
        System.out.println(crateForZebra.empty());

        // The following doesn't compile
        // crateForElephant.packCrate(new Zebra("Mimi"));
        // crateForZebra.packCrate("zebra1");

        // use a parametrized static method
        Crate.ship(new Elephant("insignificant"));
    }

    public static <U> Crate<U> ship(U shippable) {
        System.out.println("Crate for " + shippable);
        final Crate<U> crate = new Crate<>();
        crate.packCrate(shippable);
        return crate;
    }

}
