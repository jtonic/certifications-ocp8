package ro.jtonic.cert.ocp8.ch8;

import java.io.*;
/**
 * Created by antonelpazargic on 02/06/16.
 */
public class Test21 {
    private static final File FILE = new File(
            "/Users/antonelpazargic/jtonic/git/github/certifications-ocp8/src/ro/jtonic/cert/ocp8/ch8/zebra.txt"
    ) ;

    private static final class Zebra implements Serializable {
        private transient String name = "George";
        private static String birthPlace = "Africa";
        private Object tail = null;
        private transient String species;

        {
            this.species = "herbivorous";
        }

        public Zebra() {
            this.name = "Sophia";
        }
    }

    public static void main(String... args) throws IOException, ClassNotFoundException {
        try (ObjectOutputStream oOut = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(FILE)))) {
            final Zebra zebra = new Zebra();
            zebra.tail = "my tail";
            oOut.writeObject(zebra);
        }

        try (ObjectInputStream oIn = new ObjectInputStream(new BufferedInputStream(new FileInputStream(FILE)))) {
            Object obj = oIn.readObject();
            if (obj instanceof Zebra) {
                Zebra zebra = (Zebra) obj;
                System.out.println("zebra.name = " + zebra.name);
                System.out.println("zebra.tail = " + zebra.tail);
                System.out.println("zebra.birthPlace = " + zebra.birthPlace);
                System.out.println("zebra.species = " + zebra.species);
            }
        } catch (EOFException ex) {
            // swallow it, it is correct;
        }
    }

}
