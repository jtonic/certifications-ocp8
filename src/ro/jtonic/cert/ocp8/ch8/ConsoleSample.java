// package ro.jtonic.cert.ocp8.ch8;

import java.io.*;
/**
 * Created by antonelpazargic on 31/05/16.
 */
public class ConsoleSample {

    public static void main(String... args) throws IOException {
        Console console = System.console();
        if (console == null) {
            throw new RuntimeException("Console is not supported by the OS");
        }
	    PrintWriter writer = console.writer();
        String userIn = console.readLine();
        writer.println("You entered the following: " + userIn);
        ((Writer)writer).append(".And you know that very well.\n");
	    writer.flush();
    }

}
