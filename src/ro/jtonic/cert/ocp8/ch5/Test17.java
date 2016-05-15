package ro.jtonic.cert.ocp8.ch5;

import java.util.*;

/**
 * Created by antonelpazargic on 15/05/16.
 */
public class Test17 {

    public static void main(String... args) {
        Properties props = new Properties();
        props.put("1", "one");
        props.put("2", "two");
        String p1 = (String)props.get("1");
        String p2 = (String)props.get("3");
        String p3 = props.getProperty("3", "none");
        System.out.println("p1 = " + p1);
        System.out.println("p2 = " + p2);
        System.out.println("p3 = " + p3);
    }
}
