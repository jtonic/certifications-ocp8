package ro.jtonic.cert.ocp8.ch2;

/**
 * Created by antonelpazargic on 15/04/16.
 */
public class HayStorageTest {

    public static void main(String... args) {
        final int hayQuantity = HayStorage.getInstance().getHayQuantity();
        System.out.println("Quantity =" + hayQuantity);
    }

}
