package ro.jtonic.cert.ocp8.ch1;

/**
 * Created by antonelpazargic on 12/04/16.
 */
public class RevQue9 {

    private static class Outer {
        private int x = 24;

        public int getX() {
            String message = "x is ";
            class Inner {
                private int x = Outer.this.x;
                private void printX() {
                    System.out.println(message + x);
                }
            }
            Inner in = new Inner();
            in.printX();
            return x;
        }
    }

    public static void main(String... args) {
        new Outer().getX();
    }

}
