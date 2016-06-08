import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;

public final class Test5 {
	public static void main(String... args) throws IOException {
		Path path = Paths.get("./kang");
		if (Files.isDirectory(path) && Files.isSymbolicLink(path)) {
			System.out.println("Is symbolic link pointing to a empty dir.");
			Path joey = path.resolve("joey");
			Path createdDir = Files.createDirectory(joey);
			System.out.println("Created dir: " + createdDir);
		}
	}
}
