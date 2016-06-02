package ro.jtonic.cert.ocp8.ch8;

import java.io.*;
/**
 * Created by antonelpazargic on 02/06/16.
 */
public class Test15 {
    private static final String FILE_NAME = "/Users/antonelpazargic/jtonic/git/github/certifications-ocp8/src/ro/jtonic/cert/ocp8/ch8/echo.txt";

    public static final void main(String... args) throws IOException {
        echo();
    }

    private static void echo() throws IOException {
        try (
                FileReader fileReader = new FileReader(FILE_NAME);
                BufferedReader bufferedReader = new BufferedReader(fileReader)
        ) {
                System.out.println(bufferedReader.readLine());
        }

    }
}
