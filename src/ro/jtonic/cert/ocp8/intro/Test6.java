package ro.jtonic.cert.ocp8.intro;

import java.util.*;

/**
 * Created by antonelpazargic on 04/04/16.
 */
public class Test6 {

    public static void main(String[] args) {
        List<String> lst1 = new ArrayList<>();
        lst1.add("a");
        List<String> lst2 = new ArrayList<>(lst1);

        System.out.println(lst1.size() + " " + lst2.size());

        lst2.add("b");
        lst2.add("c");
        System.out.println(lst1.size() + " " + lst2.size());

        System.out.println(lst1 + " " + lst2);

    }


}


