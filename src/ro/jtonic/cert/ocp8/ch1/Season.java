package ro.jtonic.cert.ocp8.ch1;

/**
 * Created by antonelpazargic on 09/04/16.
 */
public enum Season {
    WINTER, SPRING, SUMMER, FALL;

    public static void main(String... args) {
        Season s = Season.WINTER;
        System.out.println(s);

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