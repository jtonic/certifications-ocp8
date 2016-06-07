import java.io.*;
import java.nio.file.*;

public final class CopyMoveDelBuffered {

	public static void main(String... args) throws IOException {
		testCopy();

		System.exit(0);
	}

	private static void testCopy() throws IOException {
		Path p1 = Paths.get("./dir1/Test2.txt");
		Path p2 = FileSystems.getDefault().getPath("./dir1/Test2_copy.txt");
		Path p3 = FileSystems.getDefault().getPath("./dir1/Test2_copy.txt");
		Path p4 = FileSystems.getDefault().getPath("./dir1/Test2_copy.txt");

		Path p5 = Paths.get("./dir1");
		Path p51 = Paths.get("./dir12");
		Path p6 = Paths.get("./dir1_copy");

		// Files.copy(p1, p2);
		System.out.println("Files p2 exists: " + Files.exists(p2));
		System.out.println("Files.size(p1): " + Files.size(p1));
		System.out.println("Files.size(p2): " + Files.size(p2));

		Files.copy(p1, p3, StandardCopyOption.REPLACE_EXISTING);
		System.out.println("Files p3 exists: " + Files.exists(p3));
		System.out.println("Files.size(p1): " + Files.size(p1));
		System.out.println("Files.size(p3): " + Files.size(p3));

		Files.copy(p1, p4, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.COPY_ATTRIBUTES);
		System.out.println("Files p4 exists: " + Files.exists(p4));
		System.out.println("Files.size(p1): " + Files.size(p1));
		System.out.println("Files.size(p4): " + Files.size(p4));
		
		long lmtP1 = Files.getLastModifiedTime(p1).toMillis();
		long lmtP2 = Files.getLastModifiedTime(p2).toMillis();
		assert lmtP1 == lmtP2;

		Path copiedDir = Files.copy(p5, p6, StandardCopyOption.REPLACE_EXISTING);
		System.out.println("Copied directory: " + copiedDir.toAbsolutePath().normalize());

		Path copiedDir1 = Files.copy(p51, p6, StandardCopyOption.REPLACE_EXISTING);
		System.out.println("Copied directory: " + copiedDir1.toAbsolutePath().normalize());
	}

}
