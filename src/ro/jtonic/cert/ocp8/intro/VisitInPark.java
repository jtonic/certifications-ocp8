package ro.jtonic.cert.ocp8.intro;

/**
 * Created by antonelpazargic on 05/04/16.
 */
public class VisitInPark {

    enum AnimalsInPark {
        SQUIRREL, CHIPMUNK, SPARROW;
    }

    public static void main(String[] args) {
        AnimalsInPark[] animals = AnimalsInPark.values();
        System.out.println(animals[1]);
    }

}
