import java.nio.file.*;
import java.util.stream.*;
import java.io.IOException;

public final class Nio2Streams {
	public static void main(String... args) throws IOException {
		Path p1 = Paths.get(".");
		System.out.println("Current path: " + p1.toAbsolutePath());
		
		System.out.println("Walking through current path, using depth first algorith.");
		Files.walk(p1).filter(p -> p.toAbsolutePath().toString().endsWith(".txt"))
			.map(p -> p.toAbsolutePath().normalize())
			.forEach(System.out::println);
	}
}
