package ro.jtonic.cert.ocp8.intro;

import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import java.io.IOException;

/**
 * Created by antonelpazargic on 06/04/16.
 */
public class Test17 {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/gorilla/signed-words.txt");
        Files.find(path.getParent(), 10, //k1
                (Path p, BasicFileAttributes attr) -> p.toString().endsWith(".txt") && Files.isDirectory(p)) // k2
                .collect(Collectors.toList())
                .forEach(System.out::println);

        Files.readAllLines(path) // k3
//                .stream()
                .flatMap(p -> Stream.of(p.split(" "))) // k4
                .map(s -> s.toLowerCase()) // k5
                .forEach(System.out::println);

    }

}
