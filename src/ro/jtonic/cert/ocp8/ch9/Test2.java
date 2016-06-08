import java.nio.file.*;

public final class Test2 {

	public static void main(String... args) throws java.io.IOException {
		Path path = Paths.get("empty_lnk");
		if (Files.isDirectory(path)) {
			System.out.println("For a symbolic link to a directory the isDirectory = true");
			Files.deleteIfExists(path);
		}
	}

}
