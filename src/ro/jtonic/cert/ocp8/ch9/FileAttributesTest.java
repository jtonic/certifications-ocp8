
import java.time.*;
import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;

public class FileAttributesTest {

	public static void main(String... args) throws java.io.IOException {
		Path p1 = Paths.get(".");		
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

