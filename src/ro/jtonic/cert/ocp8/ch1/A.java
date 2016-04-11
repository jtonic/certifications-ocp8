package ro.jtonic.cert.ocp8.ch1;

/**
 * Created by antonelpazargic on 11/04/16.
 */
public class A {

    private int x = 10;

    class B {
        private int x = 20;

        class C {
            private int x = 30;

            public void allTheX() {
                System.out.println("x = " + x);
                System.out.println("this.x = " + this.x);
                System.out.println("B.this.x = " + B.this.x);
                System.out.println("A.this.x = " + A.this.x);
            }
        }
    }

    public static void main(String... args) {
        new A().new B().new C().allTheX();
    }

}
