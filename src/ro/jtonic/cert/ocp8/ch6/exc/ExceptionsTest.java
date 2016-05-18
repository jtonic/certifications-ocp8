package ro.jtonic.cert.ocp8.ch6.exc;

import java.io.*;
import java.sql.*;
import java.time.*;
import java.time.format.*;
import java.text.ParseException;

/**
 * Created by antonelpazargic on 18/05/16.
 */
public class ExceptionsTest {

    public static void main(String... args) throws ParseException, IOException {

        parse();

        printName1("users");

        printName("users");

        System.out.println("getTime(\"10:11\") = " + getTime("10:11"));
        
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
        } catch (RuntimeException | SQLException e) {
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

    private static byte[] loadFile(String fileName) {
        try {
            throw new FileNotFoundException("The file is not found");
        // the following doesn't compile because the exceptions are related.
        // } catch (IOException | FileNotFoundException e) {
        //     e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private static LocalTime getTime(String time) {
        // the following throws a runtime/unchecked exception
        // java.time.format.DateTimeParseException: Text 'Jan 2016' could not be parsed at index 0
        return LocalTime.parse("Jan 2016", DateTimeFormatter.ofPattern("hh:mm"));
    }

    // The caught exception local variable is not effective final in normal try/catch but it is in the try/multi-catch
    private static void printName(String name) {
        try {
            throw new RuntimeException("invalid table name");
        } catch (RuntimeException e) {
            e = new IllegalArgumentException(e);
            throw e;
        }
    }

    private static void printName1(String name) {
        try {
            throw new SQLTransientException("Invalid table name");
        } catch (SQLException e) {
            e = new SQLException(e);
            e.printStackTrace();
        }
    }

    // re-throwing exception better with the multi catch
    private static void parse() throws ParseException, IOException {
        try {
            doParse();
        } catch (ParseException | IOException e) {
            System.out.println(e);
            throw e;
        }
    }

    private static void doParse() throws ParseException, IOException {
        System.out.println("Parsing....");
    }

}
