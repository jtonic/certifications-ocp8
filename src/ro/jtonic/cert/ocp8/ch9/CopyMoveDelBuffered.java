import java.io.*;
import java.nio.file.*;

public final class CopyMoveDelBuffered {

	public static void main(String... args) throws IOException {
		testDelete();
		System.exit(0);
		testMove();
		testCopyUsingIo();
		testCopy();
	}
	
	private static void testDelete() throws java.io.IOException {
		Path p1 = Paths.get("./dir_to_be_deleted_1");
		Path p2 = Paths.get("./dir_to_be_deleted_2");
		Path directoryToDelete = Files.createDirectory(p1);
		Files.delete(directoryToDelete);

		Path directoryToDelete2 = Files.createDirectory(p2);
		boolean deleted = Files.deleteIfExists(directoryToDelete2);
		System.out.println("Was the directory deleted? " + deleted);
	}	

	private static void testMove() throws java.io.IOException {
		Path p1 = Files.move(Paths.get("./dir1"), Paths.get("./dir1_moved"));	
		System.out.println("The path of the moved file: " + p1.toAbsolutePath().normalize());
	}

	private static void testCopyUsingIo() throws java.io.FileNotFoundException, java.io.IOException {
		try (
			InputStream is = new FileInputStream("./CopyMoveDelBuffered.lnk");
			OutputStream os = new FileOutputStream("./CopyMoveDelBuffered.copy.1")
		) {
			Files.copy(is, Paths.get("./CopyMoveDelBuffered.tmp"));
			Files.copy(Paths.get("./CopyMoveDelBuffered.tmp"), os);
		} 
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

		System.out.println("Copy a link file.");
		Path p7 = Paths.get("./CopyMoveDelBuffered.lnk");
		Path p8 = Paths.get("./CopyMoveDelBuffered.copy");
		Path p9 = Files.copy(p7, p8, StandardCopyOption.REPLACE_EXISTING, LinkOption.NOFOLLOW_LINKS);
		System.out.println("Copied symbolic link file: " + p9.normalize());

		Path copiedDir1 = Files.copy(p51, p6, StandardCopyOption.REPLACE_EXISTING);
		System.out.println("Copied directory: " + copiedDir1.toAbsolutePath().normalize());
	}

}
