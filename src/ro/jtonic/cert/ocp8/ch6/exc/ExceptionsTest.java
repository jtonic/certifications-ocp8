package ro.jtonic.cert.ocp8.ch6.exc;

import java.io.*;
import java.sql.*;
/**
 * Created by antonelpazargic on 18/05/16.
 */
public class ExceptionsTest {

    public static void main(String... args) {
        Cage cage = new Cage(3, 10, -5);
        System.out.println("cage.getVolume() = " + cage.getVolume());

        String[] strs = {"1", "2", "3"};
        Object[] objs = strs;
        objs[2] = new StringBuilder("3"); //java.lang.ArrayStoreException: java.lang.StringBuilder
        foo();
        System.out.println(1 / 0);
    }

    private static void foo() {
        // it is not implemente yet
        throw new UnsupportedOperationException("Not implemented yet");
    }

    private static void fee() {
        try {
            loadData("select 1 from dual");
        } catch (RuntimeException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        // the following catch clause doesn't compile cause the IllegalArgumentException is a subclass of the RuntimeException which is already caught
        // } catch (IllegalArgumentException e) {
        //     e.printStackTrace();
        // the following is not allowed cause the checked java.io.IOException is not thrown in the try clause
        // } catch (IOException e) {
        //     e.printStackTrace();
        }
    }

    private static byte[] loadData(String query) throws SQLException { // this is allowed even if the checked exception is not thrown
        throw new UnsupportedOperationException("It is not implemented yet");
    }

}
