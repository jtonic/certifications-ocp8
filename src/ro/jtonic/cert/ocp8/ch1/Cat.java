package ro.jtonic.cert.ocp8.ch1;

/**
 * Created by antonelpazargic on 08/04/16.
 */
public abstract class Cat {
    private void clean() {
        System.out.println("in cat class");
    }

    public static void main(String[] args) {
        Cat cat = new Lion();
        cat.clean();
    }
}

class Lion extends Cat {
    private void clean() {
        System.out.println("in Lion class");
    }
}
