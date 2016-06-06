package ro.jtonic.cert.ocp8.ch9;

import java.nio.file.*;
import java.util.stream.*;
import java.io.IOException;

public final class Nio2Streams {
	public static void main(String... args) throws IOException {
		Path p1 = Paths.get("./Test.txt");
		// Path p1 = Paths.get(".");
		boolean fileExists = Files.exists(p1);
		System.out.println("File exists? " + fileExists);
		if (!fileExists) {
			System.out.println("File doesn't exists. Exit the app");
			System.exit(1);
		}

		System.out.println("Current path: " + p1.toAbsolutePath());
		System.out.println("File size: " + Files.size(p1));

		testLines(p1);
		System.exit(0);

		testList(p1);
		testFind(p1);
		testWalk(p1);
	}

	private static void testLines(Path path) throws java.io.IOException {
		Files
			.lines(path)
			.forEach(System.out::println)
		;	
	}

	private static void testList(Path path) throws java.io.IOException {
		Stream<Path> s = Files.list(path);
		s
			.filter(p -> Files.isDirectory(p))
			.map(p -> p.toAbsolutePath())
			.forEach(System.out::println);
	}

	private static void testFind(Path path) throws java.io.IOException {
		Files.find(path, 2, (p, a) -> p.toString().startsWith(".txt") && a.size() > 100)
			.forEach(p -> {
			System.out.println("Path: " + p);
		});
	}

	private static void testWalk(Path path) throws IOException {
		System.out.println("Walking through current path, using depth first algorith.");
		Files.walk(path).filter(p -> p.toAbsolutePath().toString().endsWith(".txt"))
			.map(p -> p.toAbsolutePath().normalize())
			.forEach(System.out::println);
	}

}
