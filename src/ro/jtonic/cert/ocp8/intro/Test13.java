package ro.jtonic.cert.ocp8.intro;

import java.io.Console;

/**
 * Created by antonelpazargic on 05/04/16.
 */
public class Test13 {

    public static void main(String[] args) {
        String line;
        Console c = System.console();
        if((line = c.readLine()) != null) {
            System.out.println(line);
        }
    }
}
