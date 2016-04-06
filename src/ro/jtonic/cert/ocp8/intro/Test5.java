package ro.jtonic.cert.ocp8.intro;

import java.util.*;
import java.util.concurrent.*;

/**
 * Created by antonelpazargic on 04/04/16.
 */
public class Test5 {

    public static void main(String[] args) {
        List<Integer> source = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> fish = new CopyOnWriteArrayList<>(source);
        List<Integer> mammals = Collections.synchronizedList(source);
        Set<Integer> birds = new ConcurrentSkipListSet<>();
        birds.addAll(source);

        synchronized(new Integer(10)) {
            for(Integer f: fish) fish.add(4);
            for(Integer m: mammals) mammals.add(4);
            for(Integer b: birds) birds.add(5);

            System.out.println(fish.size() + " " + mammals.size() + " " + birds.size());
        }
    }

}
