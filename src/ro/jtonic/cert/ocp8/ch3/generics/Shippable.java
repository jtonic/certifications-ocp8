package ro.jtonic.cert.ocp8.ch3.generics;

import static ro.jtonic.cert.ocp8.ch3.generics.Crate.*;

/**
 * Created by antonelpazargic on 25/04/16.
 */
public interface Shippable<T> {

    void ship(T t);

    static void main(String... args) {
        ShippableRobotCrate robCrate = new ShippableRobotCrate();
        robCrate.ship(new Robot("ET"));

        AbstractShippableCrate<Elephant> elephantShippableCrate =
                new AbstractShippableCrate<>();
        elephantShippableCrate.ship(new Elephant("Tiny"));

        ShippableCrate shippableCrate = new ShippableCrate();
        shippableCrate.ship(new Zebra("ShortNeck"));
    }
}

class ShippableRobotCrate implements Shippable<Robot> {

    @Override
    public void ship(Robot robot) {
        System.out.println("Shipping a robot with special crate");
    }

}

class AbstractShippableCrate<U> implements Shippable<U> {
    @Override
    public void ship(U u) {
        System.out.println("Shipping a generic shippable: " + u);
    }
}

class ShippableCrate implements Shippable {
    @Override
    public void ship(Object object) {
        System.out.println("Sipping an object: " + object);
    }
}

class Robot {
    private String name;

    public Robot(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
