package ro.jtonic.cert.ocp8.intro;

import java.util.Scanner;
import java.util.jar.Pack200;

/**
 * Created by antonelpazargic on 05/04/16.
 */
public class Test14 {

    class RainException extends Exception{}

    public static void main(String[] args) {
        try(Scanner s = new Scanner("rain"); String line = "";) {
            if(s.nextLine().equals("rain"))
                throw new RainException();
        } finally {
            s.close();
        }
    }

}
