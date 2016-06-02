package ro.jtonic.cert.ocp8.ch8;

import java.io.*;
/**
 * Created by antonelpazargic on 02/06/16.
 */
public class PrintWriterTest {

    private static final File FILE = new File("/Users/antonelpazargic/jtonic/git/github/certifications-ocp8/src/ro/jtonic/cert/ocp8/ch8/printwriter1.log");

    private static final class Person {
        private String name;

        public Person(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person [name= " + this.name + "]";
        }
    }

    public static void main(String... args) throws FileNotFoundException, IOException {
        try (
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE)));
        ) {
            out.print(5);
            // out.write(System.getProperty("line.separator"));
            out.print(0.5);
            out.println();
            out.println("Antonel is the best person ever, but he is quite selfish once in a while.");
            Person person = new Person("Antonel");
            out.println(person);

            out.write(person == null ? "null" : String.valueOf(person));
            out.println();

            out.printf("My brother %s is the best photographer in the whole world.%n", "Tutye");
            out.format("My sister %s is the most beautiful woman in the world.%n", "Irina");
            System.out.println("line separator: " + System.getProperty("line.separator"));

            final boolean anyErrors = out.checkError();
            if (anyErrors) {
                System.out.println("Errors has been encountered.");
            } else {
                System.out.println("No print to console errors has been encountered.");
            }
        }
    }
}
