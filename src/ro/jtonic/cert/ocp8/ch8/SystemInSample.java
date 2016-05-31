package ro.jtonic.cert.ocp8.ch8;

import java.io.*;
/**
 * Created by antonelpazargic on 31/05/16.
 */
public class SystemInSample {

    public static void main(String... args) throws java.io.IOException {
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        String userIn = bReader.readLine();
        System.out.println("You entered the following: " + userIn);

        // bReader.close(); // Don't close the System.in InputStream otherwise the following reading operation with it throws the java.io.IOException: Stream closed

        char a = (char)System.in.read(); // This throws an exception if the bReader is closed (meaning the low level System.in InputStream is closed)
        System.out.println("You entered: " + a);

    }

}
