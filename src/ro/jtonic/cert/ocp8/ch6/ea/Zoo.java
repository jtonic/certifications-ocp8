package ro.jtonic.cert.ocp8.ch6.ea;

/**
 * Created by antonelpazargic on 18/05/16.
 */
public class Zoo {

    private int visitorsNumber;

    public static enum Seasons {SPRING, SUMMER, FALL, WINTER}

    public Zoo(int visitorsNumber) {
        if (visitorsNumber <= 0) {
            throw new IllegalArgumentException("The number of visitors should be greater than zero");
        }
        this.visitorsNumber = visitorsNumber;
    }

    public int getVisitorsNumber() {
        assert isValid() : "The Zoo is ready";
        return this.visitorsNumber;
    }

    private boolean isValid() {
        return this.visitorsNumber > 0;
    }

    public String getOpeningHours(Seasons season) {
        switch (season) {
            case SPRING:
            case FALL: return "Short schedule: 10-16";
            case SUMMER:
                return "Long schedule: 9-21";
            default:
                assert false : "Invalid season";
                return "No schedule";
        }
    }

}
