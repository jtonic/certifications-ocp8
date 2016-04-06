package ro.jtonic.cert.ocp8.intro;

/**
 * Created by antonelpazargic on 06/04/16.
 */

import java.util.*;

public class Test18 {

    public static void main(String[] args) {
        Set<? extends RuntimeException> set =
                new TreeSet<NullPointerException>();
        set = new TreeSet<RuntimeException>();
        set = new HashSet<? extends RuntimeException>();
        set = new HashSet<Exception>();
    }

}
