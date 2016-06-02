package ro.jtonic.cert.ocp8.ch8;

import java.io.*;
/**
 * Created by antonelpazargic on 01/06/16.
 */
public class IOSamples {

    public static void main(String... args) throws IOException {
        try(
                BufferedWriter bw = new BufferedWriter(new FileWriter("/Users/antonelpazargic/jtonic/git/github/certifications-ocp8/src/ro/jtonic/cert/ocp8/ch8/Zoo.txt"));
                BufferedReader br = new BufferedReader(new FileReader("/Users/antonelpazargic/jtonic/git/github/certifications-ocp8/src/ro/jtonic/cert/ocp8/ch8/Zoo.txt"))
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
}
