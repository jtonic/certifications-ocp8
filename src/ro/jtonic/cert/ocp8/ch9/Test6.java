import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.*;
import java.io.IOException;

public final class Test6 {

	public static void main(String... args) throws IOException {
		Path path = Paths.get("./animals");
		boolean myBoolean = Files.walk(path)
			.peek(System.out::println)
			//.filter((p, a) -> a.isDirectory() && !path.equals(p))
			.filter(p -> Files.isDirectory(p) && !path.equals(p))
			.peek(System.out::println)
			.findFirst().isPresent();
		System.out.println(myBoolean? "No sub-directory": "Has sub-directory");
	}

}
