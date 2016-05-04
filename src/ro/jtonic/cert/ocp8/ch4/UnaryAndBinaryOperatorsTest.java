package ro.jtonic.cert.ocp8.ch4;

import java.util.*;
import java.util.function.*;

/**
 * Created by antonelpazargic on 04/05/16.
 */
public class UnaryAndBinaryOperatorsTest {

    public static void main(String... args) {
        UnaryOperator<String> toUpperCase = String::toUpperCase;
        System.out.println("toUpperCase.apply(\"jtonic\") = " + toUpperCase.apply("jtonic"));

        BinaryOperator<String> concat = String::concat;
        System.out.println("concat.apply(\"jtonic\", \" tutye\") = " + concat.apply("jtonic", " tutye"));
    }

}
