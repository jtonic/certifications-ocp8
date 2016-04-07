package ro.jtonic.cert.ocp8.intro;

import java.io.*;
import java.nio.file.*;

/**
 * Created by antonelpazargic on 04/04/16.
 */
public class Test7 {

    public static void main(String[] args) throws IOException {
        Path path1 = Paths.get("/Users/antonelpazargic/jtonic/tmp/night", "../").resolve("./sort.swift").normalize();
        Path path2 = new File("../sleep.txt").toPath().toRealPath();
        System.out.println(Files.isSameFile(path1, path2));
        System.out.println(" " + path1.equals(path2));
    }

}
