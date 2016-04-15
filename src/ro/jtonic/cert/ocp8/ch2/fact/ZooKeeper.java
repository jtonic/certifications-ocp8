package ro.jtonic.cert.ocp8.ch2.fact;

/**
 * Created by antonelpazargic on 15/04/16.
 */
public class ZooKeeper {

    public static void main(String... args) {
        final Food food = FoodFactory.getFood("polar bear");
        food.consumed();
    }

}
