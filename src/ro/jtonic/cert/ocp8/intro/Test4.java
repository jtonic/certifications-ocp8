package ro.jtonic.cert.ocp8.intro;

/**
 * Created by antonelpazargic on 06/04/16.
 */
public class Test4 {

    private static class Box<T> {
        T value;

        public Box(T value) {
            this.value = value;
        }

        public T getValue() {
            return this.value;
        }

    }

    public static void main(String[] args) {
        Box<String> one = new Box<String>("a string");
        Box<Integer> two = new Box<Integer>(123);
        System.out.println(one.getValue());
        System.out.println(two.getValue());
    }

}
