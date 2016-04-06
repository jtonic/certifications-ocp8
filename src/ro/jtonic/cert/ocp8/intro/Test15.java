package ro.jtonic.cert.ocp8.intro;

import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import java.io.IOException;

/**
 * Created by antonelpazargic on 06/04/16.
 */
public class Test15 {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/gorilla/signed-words.txt");
        Files.find(path.getParent(), 10.0, (Path p) -> p.toString().endsWith(".txt") && Files.isDirectory(p))
                .collect(Collectors.toList())
                .forEach(System.out::println);
        Files.readAllLines(path)
                .flatMap(p -> Stream.of(p.split(" ")))
                .map(s -> s.toLowerCase())
                .forEach(System.out::println);

    }

}
