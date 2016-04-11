package ro.jtonic.cert.ocp8.ch1;

/**
 * Created by antonelpazargic on 11/04/16.
 *
 * Anonymous inner class implementing an interface
 *
 */
public class AnonInner {

    interface SaleTodayOnly {
        int dollarsOff();
    }

    public int admission(int basePrice) {
        return basePrice - new SaleTodayOnly() {
            public int dollarsOff() {
                return 3;
            }
        }.dollarsOff();
    }

    public static void main(String... args) {
        AnonInner inner = new AnonInner();
        final int admission = inner.admission(10);
        System.out.println("admission = " + admission);
    }

}
