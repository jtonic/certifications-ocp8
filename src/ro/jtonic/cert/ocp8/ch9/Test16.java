import java.nio.file.*;
import java.util.stream.*;

public final class Test16 {

	public static void main(String... args) throws java.io.IOException {
		Path path = Paths.get("dir1_moved/Test2.txt");
		Files.lines(path)
			.flatMap(p -> Stream.of(p.split(",")))
			.map(s -> s.toUpperCase())
			.forEach(System.out::println);
	}

}
