package ro.jtonic.cert.ocp8.ch1;

/**
 * Created by antonelpazargic on 09/04/16.
 */
public enum Season {
    WINTER("low") {
        public void printHours() {
            System.out.println("9am - 3pm");
        }
    }, SPRING("medium") {
        public void printHours() {
            System.out.println("9am - 5pm");
        }
    }, SUMMER("high") {
        public void printHours() {
            System.out.println("9am - 7pm");
        }
    }, FALL("medium") {
        public void printHours() {
            System.out.println("9am - 5pm");
        }
    };

    private String expectedVisitors;

    Season(String expectedVisitors) {
        this.expectedVisitors = expectedVisitors;
    }

    public void printExpectedVisitors(){
        System.out.println(this.expectedVisitors);
    }

    public abstract void printHours();

    public static void main(String... args) {
        Season s = Season.WINTER;
        System.out.println(s);
        Season.SUMMER.printExpectedVisitors();
        Season.SUMMER.printHours();

        System.out.println(s == Season.WINTER);

        Season[] seasons = Season.values();
        for(Season season: seasons) {
            System.out.println(season.name() + " " + season.ordinal());
        }

        final Season summer1 = Season.valueOf("SUMMER");
        System.out.println(summer1);
//        final Season summer2 = Season.valueOf("summer"); //Exception in thread "main" java.lang.IllegalArgumentException: No enum constant ro.jtonic.cert.ocp8.ch1.Season.summer
//        System.out.println(summer2);

        switch(summer1) {
            case SUMMER:
                System.out.println("time for pool");
                break;
            case WINTER:
                System.out.println("get out the sled");
                break;
            default:
                System.out.println("Isn't summer already?");
        }

    }
}