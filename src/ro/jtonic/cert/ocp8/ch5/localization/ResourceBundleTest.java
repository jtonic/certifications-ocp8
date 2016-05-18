package ro.jtonic.cert.ocp8.ch5.localization;

import java.util.*;
import java.text.*;

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

        // the following properties file resource bundle is missing.
        // java.util.MissingResourceException: Can't find bundle for base name ro.jtonic.cert.ocp8.ch5.localization.ZooRomania, locale ro_RO
        ResourceBundle rbRo1 = ResourceBundle.getBundle("ro.jtonic.cert.ocp8.ch5.localization.ZooRomania", ro);

        System.out.println("US hello: " + rbUs.getString("hello"));
        System.out.println("US open: " + rbUs.getString("open"));
        System.out.println("Default name for en_US: " + rbUs.getString("name"));

        // the following resource key is missing
        System.out.println("US hello: " + rbUs.getString("hi")); // java.util.MissingResourceException: Can't find resource for bundle java.util.PropertyResourceBundle, key hi

        System.out.println("RO hello: " + rbRo.getString("hello"));
        System.out.println("RO open: " + rbRo.getString("open"));
        final String roName = MessageFormat.format(rbRo.getString("name"), "Bucuresti, Ferentari");
        System.out.println("Name for ro_RO: " + roName);

        System.out.println("fr_CA hello: " + rbCaFr.getString("hello"));
        System.out.println("fr_CA open: " + rbCaFr.getString("open"));
        System.out.println("Default name for fr_CA: " + rbCaFr.getString("name"));

        System.out.println("\n\nPrint all messages from the property based en_US resource bundle");
        rbUs.keySet().stream().map(k -> k + ": " + rbUs.getString(k)).forEach(System.out::println);

        System.out.println("Using java.util.Properties in order to have a default values for missing properties");
        System.out.println("==============");
        Properties propsRo = new Properties();
        rbRo.keySet().stream().forEach(k -> propsRo.put(k, rbRo.getString(k)));
        System.out.println("propsRo.getProperty(\"name\") = " + MessageFormat.format(propsRo.getProperty("name"), "Bucuresti, Baneasa"));
        System.out.println("propsRo.getProperty(\"hello\") = " + propsRo.getProperty("hello"));
        System.out.println("propsRo.getProperty(\"open\") = " + propsRo.getProperty("open"));
        System.out.println("propsRo.getProperty(\"missing\", \"n/a\") = " + propsRo.getProperty("missing", "n/a"));
        System.out.println("propsRo.get(\"hello\") = " + propsRo.get("hello"));
        System.out.println("propsRo.get(\"missing\") = " + propsRo.get("missing"));

        System.out.println("Get german translations from the java class");
        System.out.println("========================");
        ResourceBundle rbDe = ResourceBundle.getBundle("ro.jtonic.cert.ocp8.ch5.localization.Zoo", Locale.GERMANY);
        System.out.println("rbDe.getString(\"name\") = " + rbDe.getString("name"));
        System.out.println("rbDe.getString(\"hello\") = " + rbDe.getString("hello"));
        System.out.println("rbDe.getString(\"open\") = " + rbDe.getString("open"));
        System.out.println("(Integer)rbDe.getObject(\"ticket_price\") = " + (Integer)rbDe.getObject("ticket_price"));
        // System.out.println("rbDe.getString(\"missing\") = " + rbDe.getString("missing")); // the missing key throws and runtime exception
        // Exception in thread "main" java.util.MissingResourceException: Can't find resource for bundle java.util.PropertyResourceBundle, key missing
        // Use java.util.Properties to get null or to use a default value


    }

}
