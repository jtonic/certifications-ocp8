package ro.jtonic.cert.ocp8.ch2;

/**
 * Created by antonelpazargic on 15/04/16.
 */
public class VisitorTicketTracker {

    private int ticketNo;

    private static volatile VisitorTicketTracker instance;

    private VisitorTicketTracker() {}

    public static VisitorTicketTracker getInstance() {
        if(instance == null) {
            synchronized(VisitorTicketTracker.class) {
                if (instance == null) {
                    instance = new VisitorTicketTracker();
                }
            }
        }
        return instance;
    }

    public int getTicketNo() {
        return this.ticketNo;
    }

    public synchronized void setTicketNo(int ticketNo) {
        this.ticketNo = ticketNo;
    }

}
