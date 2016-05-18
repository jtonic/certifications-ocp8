package ro.jtonic.cert.ocp8.ch6.exc;


/**
 * Created by antonelpazargic on 18/05/16.
 */
public class Trap implements AutoCloseable {

    @Override
    public void close() {
        System.out.println("Closing the resource");
    }

    public static void main(String... args) {
        try(Trap trap = new Trap()) {
            System.out.println("Inside the try with resources");
        }
    }

}
