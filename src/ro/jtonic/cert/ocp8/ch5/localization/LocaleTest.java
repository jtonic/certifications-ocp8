package ro.jtonic.cert.ocp8.ch5.localization;

import java.util.*;

/**
 * Created by antonelpazargic on 11/05/16.
 */
public class LocaleTest {

    public static void main(String... args) {
        Locale l = Locale.getDefault();
        System.out.println("Default locale: " + l);

        System.out.println(Locale.GERMAN);
        System.out.println(Locale.GERMANY);
        System.out.println(Locale.CANADA);
        System.out.println(Locale.CANADA_FRENCH);


        System.out.println(new Locale("hi"));
        System.out.println(new Locale("hi_IN"));
        System.out.println(new Locale("ro"));
        System.out.println(new Locale("ro_RO"));

        l = new Locale.Builder().setLanguage("en").setRegion("US").build();
        System.out.println("Builder based locale: " + l);

        // Even the below is legal don't use it!!!! The Locale.Builder automatically converts codes to the right case
        l = new Locale.Builder().setLanguage("En").setRegion("uS").build();
        System.out.println(l);

        System.out.println("Setting up the default locale. This doesn't affect the system local or other programs locale");
        l = new Locale("en", "CA");
        // l = Locale.CANADA;
        // l = new Locale.Builder().setLanguage("en").setRegion("CA").build();
        System.out.println("the new default locale: " + l);

        l = new Locale("fr");
        System.out.println("Only language locale: " + l);
    }

}
