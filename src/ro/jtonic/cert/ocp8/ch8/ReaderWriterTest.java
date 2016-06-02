package ro.jtonic.cert.ocp8.ch8;

import java.io.*;
/**
 * Created by antonelpazargic on 02/06/16.
 */
public class ReaderWriterTest {
    private static final String FILE_NAME = "/Users/antonelpazargic/jtonic/git/github/certifications-ocp8/src/ro/jtonic/cert/ocp8/ch8/Zoo.txt";
    private static final String NEW_FILE_NAME = "/Users/antonelpazargic/jtonic/git/github/certifications-ocp8/src/ro/jtonic/cert/ocp8/ch8/Zoo1.txt";

    private static final File FILE1 = new File(FILE_NAME);
    private static final File FILE2 = new File(NEW_FILE_NAME);

    public static void main(String... args) throws IOException {
        bufferedCopy(FILE1, FILE2);
        System.exit(0);
        basicCopy(FILE1, FILE2);
    }

    private static void bufferedCopy(File from, File to) throws FileNotFoundException, IOException {
        try (
                BufferedReader r = new BufferedReader(new FileReader(from));
                BufferedWriter w = new BufferedWriter(new FileWriter(to))
        ) {
            String line;
            while ((line = r.readLine()) != null) {
                w.write(line);
                w.newLine();
                w.flush();
            }
        }
        System.out.printf("The file %s has been copied to %s.\n", from.getName(), to.getName());
    }

    private static void basicCopy(File from, File to) throws FileNotFoundException, IOException {
        try (
                Reader r = new FileReader(from);
                Writer w = new FileWriter(to);
        ) {
            char[] buffer = new char[1024];
            int readCharsNo;
            while ((readCharsNo = r.read(buffer)) != -1) {
                w.write(buffer, 0, readCharsNo);
                w.flush();
            }
            System.out.printf("The file %s has been copied to %s\n", from.getName(), to.getName());
        }
    }

}
