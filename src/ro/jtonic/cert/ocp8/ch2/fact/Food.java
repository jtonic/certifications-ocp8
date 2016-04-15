package ro.jtonic.cert.ocp8.ch2.fact;

/**
 * Created by antonelpazargic on 15/04/16.
 */
public abstract class Food {

    private int quantity;

    public Food(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public abstract void consumed();

}

class Hay extends Food {
    public Hay(int quantity) {
        super(quantity);
    }

    @Override
    public void consumed() {
        System.out.println("Hay eaten: " + getQuantity());
    }
}

class Pallets extends Food {

    public Pallets(int quantity) {
        super(quantity);
    }

    @Override
    public void consumed() {
        System.out.println("Pallets eaten: " + getQuantity());
    }
}

class Fish extends Food {
    public Fish(int quantity) {
        super(quantity);
    }
    public void consumed() {
        System.out.println("Fish eaten: " + getQuantity());
    }
}
