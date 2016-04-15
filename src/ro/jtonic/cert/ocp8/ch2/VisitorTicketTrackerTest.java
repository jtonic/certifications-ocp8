package ro.jtonic.cert.ocp8.ch2;

/**
 * Created by antonelpazargic on 15/04/16.
 */
public class VisitorTicketTrackerTest {

    public static void main(String... args) {
        VisitorTicketTracker.getInstance().setTicketNo(100);
        System.out.println(VisitorTicketTracker.getInstance().getTicketNo());
    }

}
