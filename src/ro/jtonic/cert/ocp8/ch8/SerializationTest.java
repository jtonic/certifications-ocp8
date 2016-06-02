package ro.jtonic.cert.ocp8.ch8;

import java.io.*;
import java.util.*;
/**
 * Created by antonelpazargic on 02/06/16.
 */
public class SerializationTest {

    private static final File FILE = new File("/Users/antonelpazargic/jtonic/git/github/certifications-ocp8/src/ro/jtonic/cert/ocp8/ch8/animals_data.txt");

    private static class Zoo {
        private String name;

        public Zoo(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        @Override
        public String toString() {
            return "Zoo [" + this.getName() + "]";
        }
    }

    private static final class Animal implements Serializable {
        private static final long  serialVersionUID = 1L;

        private static String animalsClass;

        private String name;
        private int age;
        private char type;

        private Zoo zoo;

        private transient String animalIdentifier;

        public Animal(String name, int age, char type, Zoo zoo) {
            this.name = name;
            this.age = age;
            this.type = type;
            this.animalIdentifier = "ID";
            this.zoo = zoo;
        }

        public String getName() { return name; }
        public int getAge() { return age; }
        public char getType() { return type; }
        public Zoo getZoo() { return this.zoo; }

        public void setAnimalIdentifier(String animalIdentifier) {
            this.animalIdentifier = animalIdentifier;
        }
        public String getAnimalIdentifier() {
            return this.animalIdentifier;
        }

        public static String getAnimalsClass() {
            return animalsClass;
        }

        @Override
        public String toString() {
            return "Animal [name=" + name + ", age=" + age + ", type= " + type + "]";
        }
    }

    public static void main(String... args) throws IOException, java.lang.ClassNotFoundException {
        Zoo zoo = new Zoo("Zoo");
        List<Animal> animals = Arrays.asList(
                new Animal("Leon", 10, 'p', zoo),
                new Animal("Tiger", 2, 'p', zoo),
                new Animal("Cobra", 40, 's', zoo),
                new Animal("Monkey", 2, 'i', zoo),
                new Animal("Zebra", 10, 'y', zoo),
                new Animal("Giraffe", 20, 'y', zoo));
        System.out.println("The animal names that will be stored in the date file.");
        System.out.println(animals);

        createAnimalsFile(animals, FILE);

        System.out.println("The animal names retrieved from the data file");
        final List<Animal> retrievedAnimals = getAnimals(FILE);
        System.out.println(retrievedAnimals);

        final Animal animal = retrievedAnimals.iterator().next();
        System.out.println("animal.getAnimalsClass() = " + animal.getAnimalsClass());
        System.out.println("animal identifier= " + animal.getAnimalIdentifier());
    }

    private static void createAnimalsFile(List<Animal> animals, File dataFile) throws FileNotFoundException, IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(dataFile)))) {
            for (Animal animal: animals) {
                oos.writeObject(animal);
            }
        }
    }

    private static List<Animal> getAnimals(File file) throws FileNotFoundException, IOException, java.lang.ClassNotFoundException {
        List<Animal> animals = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
            while (true) {
                Object obj = ois.readObject();
                if (obj instanceof Animal) {
                    animals.add((Animal) obj);
                }
            }
        } catch (EOFException e) {
            // System.out.println("It is ok to swallow this EOFException.");
            // e.printStackTrace();
            // it is ok to swallow this exception
        }
        return animals;
    }
}
