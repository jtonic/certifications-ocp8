package ro.jtonic.cert.ocp8.intro;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by antonelpazargic on 05/04/16.
 */
public class Test12 {

    public static void main(String[] args) {
        Locale fr = new Locale("fr");
        ResourceBundle b = ResourceBundle.getBundle("Dolphins", fr);
        String name = b.getString("name");
        String age = b.getString("age");
        System.out.println(name + " " + age);
    }

}
