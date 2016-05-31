import java.io.*;
import java.util.*;

public class FileSample {

	public static void main(String... args) {
		File file1 = new File("/Users/antonelpazargic/jtonic/git/github/certifications-ocp8/src/ro/jtonic/cert/ocp8/ch8/Zoo1.txt");
		System.console().writer().println(file1.exists());
		File file2 = new File("/Users/antonelpazargic/jtonic/git/github/certifications-ocp8/src/ro/jtonic/cert/ocp8/ch8"); 
		System.out.println("file2.exists? " + file2.exists());
		System.out.println("file2.isDirectory? " + file2.isDirectory());
		System.out.println("file2.getName() " + file2.getName());
		
		File fileZoo = new File("/Users/antonelpazargic/jtonic/git/github/certifications-ocp8/src/ro/jtonic/cert/ocp8/ch8/Zoo.txt");
		System.out.println("fileZoo.isFile() " + fileZoo.isFile());
		System.out.println("fileZoo.length() " + fileZoo.length());
		System.out.println("fileZoo.lastModified() " + fileZoo.lastModified());

		System.out.println("fileZoo.getParent() :" + fileZoo.getParent());
		String dirName = "newDir" + new Random().nextInt(10000);
		File fooDir = new File(file2, dirName);

		boolean created = fooDir.mkdir();
		if (created) {
			System.out.println("Was the newDir created? " + created);
			String fooName1 = "newDir" + new Random().nextInt(10000);
			File fooDir1 = new File(fooName1);
			boolean renamed = fooDir.renameTo(fooDir1);
			if (renamed) {
				System.out.println("The " + fooDir.getName() + " was successfully renamed as " + fooDir1.getName());
				boolean deleted = fooDir1.delete();
				System.out.println("Was the " + fooDir1.getAbsolutePath() + " successfully deleted? " + deleted);
			}
		}

	}		

}
