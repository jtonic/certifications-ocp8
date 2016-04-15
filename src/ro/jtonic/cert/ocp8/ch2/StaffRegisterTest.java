package ro.jtonic.cert.ocp8.ch2;

/**
 * Created by antonelpazargic on 15/04/16.
 */
public class StaffRegisterTest {

    public static void main(String... args) {
        int registration = StaffRegister.getInstance().getRegistration();
        System.out.println("registration = " + registration);
    }

}
