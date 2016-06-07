
import java.time.*;
import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;

public class FileAttributesTest {

	public static void main(String... args) throws java.io.IOException {
		Path p1 = Paths.get(".");		
		rwFilePropertiesTest(p1);
		System.exit(0);
		readOnlyFilePropertiesTest(p1);
	}

	private static void rwFilePropertiesTest(Path p) throws java.io.IOException {
		BasicFileAttributeView attrv = Files.getFileAttributeView(p, BasicFileAttributeView.class);
		BasicFileAttributes attrs = attrv.readAttributes();
		
		System.out.println("Is directory: " + attrs.isDirectory());
		System.out.println("Is regular file: " + attrs.isRegularFile());
		System.out.println("Is symbolic link: " + attrs.isSymbolicLink());
		System.out.println("Is other: " + attrs.isOther());
		System.out.println("File size: " + attrs.size());
		System.out.println("File key: " + attrs.fileKey());

		FileTime creationTime = attrs.creationTime();
		FileTime lastModifiedTime = attrs.lastModifiedTime();
		FileTime lastAccessTime = attrs.lastAccessTime();

		System.out.println("Creation time: " + creationTime);
		System.out.println("Last modified time: " + lastModifiedTime);
		System.out.println("Last access time: " + lastAccessTime);

		lastModifiedTime = lastModifiedTime.fromMillis(lastModifiedTime.toMillis() + 10_000);
		attrv.setTimes(lastModifiedTime, null, null);

		System.out.println("New last modified time: " + lastModifiedTime);

	}

	private static void readOnlyFilePropertiesTest(Path p1) throws java.io.IOException {
		BasicFileAttributes attrs = Files.readAttributes(p1, BasicFileAttributes.class);
		System.out.println("Is directory: " + attrs.isDirectory());
		System.out.println("Is regular file: " + attrs.isRegularFile());
		System.out.println("Is symbolic link: " + attrs.isSymbolicLink());
		System.out.println("Is not file, or directory or symbolica link? " + attrs.isOther());
		System.out.println("File size: " + attrs.size());
		System.out.println("File key (if available in underlaying file system): " + attrs.fileKey());


		System.out.println("Creation time: " + attrs.creationTime());
		System.out.println("Last modified time: " + attrs.lastModifiedTime());
		
		FileTime lastAccTime = attrs.lastAccessTime();
		Instant instLastAccTime = lastAccTime.toInstant();
		System.out.println("Last access time: " + lastAccTime);
		System.out.println("Last access time as an Instant: " + instLastAccTime);
	}

}

