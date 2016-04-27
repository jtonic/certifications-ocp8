package ro.jtonic.cert.ocp8.ch3.generics;

import java.util.*;

/**
 * Created by antonelpazargic on 26/04/16.
 */
public class GenericsQuestions {

    static class A { }

    static class B extends A { }

    static class C extends B { }

    <B extends A> B method3(List<B> list) {
        return new B();
    }

    <X> void method5(List<X super B> list) { }

}
