package ro.jtonic.cert.ocp8.ch2;

/**
 * Created by antonelpazargic on 15/04/16.
 */
public class StaffRegister {

    private final int registration = 100;

    private static final StaffRegister instance;

    static {
        instance = new StaffRegister();
        // Perform additional steps
    }

    private StaffRegister() {}

    public static StaffRegister getInstance() {
        return instance;
    }

    public int getRegistration() {
        return this.registration;
    }

}
