package ro.jtonic.cert.ocp8.intro;

import java.io.Serializable;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.ClassNotFoundException;
/**
 * Created by antonelpazargic on 06/04/16.
 */
class Tail {}

public class Bird implements Serializable {
    private String name;
    private transient int age;
    private Tail tail;

    public String getName() {
        return this.name;
    }

    public Tail getTail(){
        return this.tail;
    }

    public void setTail(Tail tail) {
        this.tail = tail;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try(InputStream is = new ObjectInputStream(new BufferedInputStream(
                new FileInputStream("birds.dat")
        ))) {
            Bird b = (Bird) ((ObjectInputStream)is).readObject();
        }
    }

}
