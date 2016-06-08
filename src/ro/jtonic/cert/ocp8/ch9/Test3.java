import java.nio.file.*;
import java.nio.file.attribute.*;

public final class Test3 {
	public static void main(String... args) throws java.io.IOException {
		Path path = Paths.get("dir1_moved");
		BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
		System.out.println("Attributes.size(): " + attributes.size());
		if (attributes.size() > 0 && attributes.creationTime().toMillis() > 0) {
			// attributes.setTimes(null, null, null); this doesn't compile setTimes is part of BasicFileAttributeView
			BasicFileAttributeView attributesView = Files.getFileAttributeView(path, BasicFileAttributeView.class);
			BasicFileAttributes atts = attributesView.readAttributes();
			attributesView.setTimes(null, null, null);
			boolean isRegularFile = attributes.isRegularFile();
			System.out.println("is regular file: " + isRegularFile);
		}
	}
}
