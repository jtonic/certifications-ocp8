package ro.jtonic.cert.ocp8.ch8;

import java.io.*;
/**
 * Created by antonelpazargic on 01/06/16.
 */
public class IOSamples {

    private static final String FILE_NAME = "/Users/antonelpazargic/jtonic/git/github/certifications-ocp8/src/ro/jtonic/cert/ocp8/ch8/Zoo.txt";

    public static void main(String... args) throws IOException {

        testMark();

        System.exit(0);

        try(
                BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME));
                BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))
        ) {
            bw.write("Antonel is the best person ever.\n");
            bw.write("and Magda loves him very much... and he loves her back.\n");
            bw.flush();
            String line;
            while((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    private static void testMark() throws FileNotFoundException, IOException {
        try (InputStream is = new FileInputStream(FILE_NAME)) {
            System.out.print((char)is.read());
            if (is.markSupported()) {
                is.mark(4);
                System.out.print((char) is.read());
                System.out.print((char) is.read());
                System.out.print((char) is.read());
                System.out.print((char) is.read());
                is.reset();
            } else {
                System.out.println("\nMark is not supported in the FileInputStream.\n");
                // is.mark(4); // mark() doesn't throw a IOException
                // System.out.print((char) is.read());
                // is.reset(); // java.io.IOException: mark/reset not supported
            }
            System.out.print((char) is.read());
            System.out.print((char) is.read());
            System.out.print((char) is.read());
            System.out.print((char) is.read());
        }
    }
}
