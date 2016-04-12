package ro.jtonic.cert.ocp8.ch1;

import java.util.*;

/**
 * Created by antonelpazargic on 12/04/16.
 */
public class RevQue14 {

    private static class IsItFurry {
        static class Chipmunk {
        }

    }

    public static void main(String... args) {
        IsItFurry.Chipmunk c = new IsItFurry.Chipmunk();
        ArrayList<IsItFurry.Chipmunk> l = new ArrayList<>();
        Runnable r = new Thread();
        int result = 0;
        if (c instanceof IsItFurry.Chipmunk) result += 1;
        if (l instanceof IsItFurry.Chipmunk) result += 2;
        if (r instanceof IsItFurry.Chipmunk) result += 4;

        System.out.println(result);
    }

}
