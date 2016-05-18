package ro.jtonic.cert.ocp8.ch6.exc;


/**
 * Created by antonelpazargic on 18/05/16.
 */
public class Trap implements AutoCloseable {

    private int no;

    private Trap(int no) {
        this.no = no;
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing the resource " + this.no);
        throw new Exception("Something bad happened while closing resource " + this.no);
    }

    public void foo() {
        System.out.println("foo is called on " + this.no);
    }

    public static void main(String... args) throws Exception {
        try(Trap trap1 = new Trap(1); Trap trap2 = new Trap(2)) {
            System.out.println("Inside the try with resources");
            trap1.foo();
            trap2.foo();
            throw new Exception("Something bad happen in try clause");
        } catch(Exception e) {
            for(Throwable ex: e.getSuppressed()) {
                System.out.println("suppressed exceptions = " + ex.getMessage());
            }
            // the following works like it does in the normal try/catch control structure
            e = new RuntimeException(e);
            // this exception is swallowed by the exception thrown in finally clause
            throw e;
        } finally {
            throw new Exception("Exception thrown in the finally block");
        }
    }

}
