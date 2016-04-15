package ro.jtonic.cert.ocp8.ch2.fact;

/**
 * Created by antonelpazargic on 15/04/16.
 */
public class FoodFactory {

    public static Food getFood(String animalName) {
        switch (animalName) {
            case "zebra":
                return new Hay(100);
            case "rabbit":
                return new Pallets(5);
            case "goat":
                return new Pallets(30);
            case "polar bear":
                return new Fish(10);
        }
        throw new UnsupportedOperationException("Unsupported animal: " + animalName);
    }

}
