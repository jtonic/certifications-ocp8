package ro.jtonic.cert.ocp8.ch5.localization;

import java.util.*;
/**
 * Created by antonelpazargic on 11/05/16.
 */
public class ResourceBundleTest {

    public static void main(String... args) {
        Locale us = Locale.US;
        Locale caFr = Locale.CANADA_FRENCH;
        Locale ro = new Locale("ro", "RO");

        System.out.println("Default locale: " + Locale.getDefault());

        ResourceBundle rbUs = ResourceBundle.getBundle("ro.jtonic.cert.ocp8.ch5.localization.Zoo", us);
        ResourceBundle rbCaFr = ResourceBundle.getBundle("ro.jtonic.cert.ocp8.ch5.localization.Zoo", caFr);
        ResourceBundle rbRo = ResourceBundle.getBundle("ro.jtonic.cert.ocp8.ch5.localization.Zoo", ro);

        System.out.println("US hello: " + rbUs.getString("hello"));
        System.out.println("US open: " + rbUs.getString("open"));
        System.out.println("Default name for en_US: " + rbUs.getString("name"));

        System.out.println("RO hello: " + rbRo.getString("hello"));
        System.out.println("RO open: " + rbRo.getString("open"));
        System.out.println("Default name for ro_RO: " + rbRo.getString("name"));

        System.out.println("fr_CA hello: " + rbCaFr.getString("hello"));
        System.out.println("fr_CA open: " + rbCaFr.getString("open"));
        System.out.println("Default name for fr_CA: " + rbCaFr.getString("name"));

        System.out.println("\n\nPrint all messages from the property based en_US resource bundle");
        rbUs.keySet().stream().map(k -> k + ": " + rbUs.getString(k)).forEach(System.out::println);

        System.out.println("Using java.util.Properties in order to have a default values for missing properties");
        System.out.println("==============");
        Properties propsRo = new Properties();
        rbRo.keySet().stream().forEach(k -> propsRo.put(k, rbRo.getString(k)));
        System.out.println("propsRo.getProperty(\"name\") = " + propsRo.getProperty("name"));
        System.out.println("propsRo.getProperty(\"hello\") = " + propsRo.getProperty("hello"));
        System.out.println("propsRo.getProperty(\"open\") = " + propsRo.getProperty("open"));
        System.out.println("propsRo.getProperty(\"missing\", \"n/a\") = " + propsRo.getProperty("missing", "n/a"));
        System.out.println("propsRo.get(\"hello\") = " + propsRo.get("hello"));
        System.out.println("propsRo.get(\"missing\") = " + propsRo.get("missing"));
    }

}
