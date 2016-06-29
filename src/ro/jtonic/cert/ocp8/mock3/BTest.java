import java.io.*;

/**
 * Created by antonelpazargic on 29/06/16.
 */
public class BTest {

    public static void main(String[] args) throws IOException, java.lang.ClassNotFoundException {
        serialize();
        deserialize();
    }

    private static void serialize() throws IOException {
        try(ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("./a.dat")))) {
            oos.writeObject(new B());
        }
    }

    private static void deserialize() throws IOException, java.lang.ClassNotFoundException {
        try(ObjectInputStream is = new ObjectInputStream(new BufferedInputStream(new FileInputStream("./a.dat")))) {
            Object obj = is.readObject();
            if(obj instanceof B) {
                B b = (B) obj;
                System.out.println(b.name);
            }
        }
    }

}
