package ro.jtonic.cert.ocp8.ch8;

import java.io.*;
/**
 * Created by antonelpazargic on 01/06/16.
 */
public class IOSamples {

    private static final String FILE_NAME = "/Users/antonelpazargic/jtonic/git/github/certifications-ocp8/src/ro/jtonic/cert/ocp8/ch8/Zoo.txt";
    private static final String NEW_FILE_NAME = "/Users/antonelpazargic/jtonic/git/github/certifications-ocp8/src/ro/jtonic/cert/ocp8/ch8/Zoo1.txt";

    public static void main(String... args) throws IOException {
        copy(FILE_NAME, NEW_FILE_NAME);
        System.exit(0);
        testSkip();
        testMark();

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

    private static void copy(String from, String to) throws FileNotFoundException, IOException {
        try (
                InputStream is = new FileInputStream(from);
                OutputStream os = new FileOutputStream(to)
        ) {
            int b;
            while ((b = is.read()) != -1) {
                os.write(b);
            }
        }
    }

    private static void testMark() throws FileNotFoundException, IOException {
        try (Reader is = new StringReader("Antonel")) {
            System.out.print((char)is.read());
            if (is.markSupported()) {
                System.out.println("Mark is supported for the StringReader.");
                is.mark(4);
                System.out.print((char) is.read());
                System.out.print((char) is.read());
                System.out.print((char) is.read());
                System.out.print((char) is.read());
                System.out.print((char) is.read());
                System.out.print((char) is.read());
                is.reset();  // in this case an exception is not thrown even if the mark position has been invalidated (the mark read limit has been passed). The API specifies that an exception may be thrown.
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

    private static void testSkip() throws IOException {
        try(Reader reader = new StringReader("jtonic")) {
            System.out.print((char) reader.read());
            long actuallySkipped = reader.skip(4);
            System.out.println("\nActually skipped chars: " + actuallySkipped);
            if (actuallySkipped <= 0) {
                System.out.println("No chars actually skipped");
                throw new RuntimeException("No chars were actually skipped.");
            }
            int readChar;
            while ((readChar = reader.read()) != -1) {
                System.out.print((char) readChar);
            }

        }
    }
}
