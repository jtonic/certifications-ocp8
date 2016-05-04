package ro.jtonic.cert.ocp8.ch4;

import java.util.function.*;
import java.util.*;
import java.time.*;

/**
 * Created by antonelpazargic on 29/04/16.
 */
public class SupplierTest {

    public static void main(String... args) {
        Supplier<LocalDate> s1 = LocalDate::now;
        Supplier<LocalDate> s2 = () -> LocalDate.now();

        LocalDate ld1 = s1.get();
        LocalDate ld2 = s2.get();

        System.out.println(ld1);
        System.out.println(ld2);

        Supplier<StringBuilder> s3 = StringBuilder::new;
        final StringBuilder sb = s3.get().append("jtonic");
        System.out.println(sb);

        Supplier<ArrayList> s4 = ArrayList::new;
        System.out.println(s4.get());

        System.out.println(s4);
    }

}
