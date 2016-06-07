import java.io.*;
import java.nio.file.*;
import java.net.URI;

public final class PathsFilesPathTest {

	public static void main(String... args) throws java.io.IOException, java.net.URISyntaxException {
		testFiles();
		System.exit(0);
		test3();
		test1();
		test2();
	}

	private static void testFiles() throws java.io.IOException {
		Path p1 = Paths.get("./dir1/Test2.txt");
		Path p2 = Paths.get("/DOES_NOT_EXIST");
		Path p3 = Paths.get("./dir1/../dir1/Test2.txt");
		Path p4 = Paths.get("/DOES_NOT_EXIST");

		Path p5 = Paths.get("/Users/antonelpazargic/jtonic/git/github/certifications-ocp8/src/ro/jtonic/cert/ocp8/ch9/dir1/symbolic");
		Path p6 = Paths.get("/Users/antonelpazargic/jtonic/git/github/certifications-ocp8");

		System.out.println("Files.exists(p1): " + Files.exists(p1));
		System.out.println("Files.exists(p2): " + Files.exists(p2));
		System.out.println("Files.exists(p3): " + Files.exists(p3));

		System.out.println("Files.isSameFile(p1, p3): " + Files.isSameFile(p1, p3));
		System.out.println("Files.isSameFile(p2, p4). Boths paths doesn't exist on the FS: " + Files.isSameFile(p2, p4));
		System.out.println("Files.isSameFile(p5, p6): " + Files.isSameFile(p5, p6));
		// System.out.println("Files.isSameFile(p1, p2): " + Files.isSameFile(p1, p2));

		System.out.println("Creating directories");
		System.out.println("=====================");
		Files.createDirectory(Paths.get("./dir1/newDirectory1"));
		Files.createDirectories(Paths.get("./dir3/dir4/newDirectory3"));
		Files.createDirectory(Paths.get("./dir2/newDirectory2"));
	} 
	
	private static void test3() throws java.io.IOException {
		Path p1 = Paths.get("/animals/reptiles/./snake");
		Path p2 = Paths.get("../crocodile");
		Path p3 = Paths.get("/birds/pigeon");
		Path p10 = Paths.get("./pigeon");
		Path p12 = Paths.get("/Users/antonelpazargic/jtonic/git/github/certifications-ocp8/src/ro/jtonic/cert/ocp8/ch9/dir1/./Test2.txt");
		Path p11 = Paths.get("/animals/reptiles/snake");
		Path pSymbLink = Paths.get("/Users/antonelpazargic/jtonic/git/github/certifications-ocp8/src/ro/jtonic/cert/ocp8/ch9/dir1/symbolic");
		System.out.println("Paths");
		System.out.println("===================");
		System.out.println("p1 = " + p1);
		System.out.println("p11 = " + p11);
		System.out.println("p10 = " + p10);
		System.out.println("p12 = " + p12);
		System.out.println("p2 = " + p2);
		System.out.println("p3 = " + p3);
	
		System.out.println("Normalized paths: ");
		System.out.println("===================");
		System.out.println("p1: " + p1.normalize());
		System.out.println("p11: " + p11.normalize());
		System.out.println("p12: " + p12.normalize());
		
		System.out.println("Resolved paths: ");
		System.out.println("===================");
		System.out.println("p1.resolve(p2): " + p1.resolve(p2));
		Path p8 = p1.resolve(p3);
		System.out.println("p1.resolve(p3): " + p8);

		Path p6 = p1.relativize(p3);
		System.out.println("p1.relativize(p3): " + p6);

		Path p7 = p11.relativize(p3);
		System.out.println("p11.relativize(p3): " + p7);
		Path p9 = p11.resolve(p7);
		System.out.println("p11.resolve(p7): " + p9);
		System.out.println("p11.resolve(p7) normalized: " + p9.normalize());

		// Path p5 = p1.relativize(p2);
		// System.out.println("p1.relativize(p2): " + p5);

		System.out.println("p12.toRealPath: " + p12.toRealPath());

		System.out.println("pSymLink.toRealPath(): " + pSymbLink.toRealPath());
			System.out.println("pSymLink.toRealPath(LinkOption.NOFOLLOW_LINKS): " + pSymbLink.toRealPath(LinkOption.NOFOLLOW_LINKS));
		System.out.println("currDir.toRealPath(): " + Paths.get(".").toRealPath(LinkOption.NOFOLLOW_LINKS));
			System.out.println("p1.toRealPath: " + p1.toRealPath());

		}
			
		private static void test1() {
			Path p1 = Paths.get("land/hippo/harry");
			System.out.println("p1: " + p1);
			
			Path p1Abs = Paths.get("/land/hippo/harry.poter");
			System.out.println("p1Abs: " + p1Abs);
			
			System.out.println("Paths elements of the p1");
			for (int i = 0; i < p1.getNameCount(); i++) {
				System.out.printf("The %d element path is %s.%n", i, p1.getName(i));
			}
			System.out.println("Paths elements of the p1Abs");
			for (int i = 0; i < p1Abs.getNameCount(); i++) {
				System.out.printf("The %d element path is %s.%n", i, p1Abs.getName(i));
			}

			System.out.println("getNameCount for /: " + Paths.get("/").getNameCount());

			System.out.println("getFileName of p1: " + p1.getFileName());
			System.out.println("getFileName of p1Abs" + p1.getFileName());

			System.out.println("getParent of p1:" + p1.getParent());
			System.out.println("getParent of 'jtonic': " + Paths.get("jtonic").getParent());

		System.out.println("get root of p1: " + p1.getRoot());
		System.out.println("get root of p1Abs: " + p1Abs.getRoot());

		System.out.println("isAbsolute for p1: " + p1.isAbsolute());
		System.out.println("isAbsolute for p1Abs: " + p1Abs.isAbsolute());

		System.out.println("toAbsolutePath for p1: " + p1.toAbsolutePath());
		System.out.println("toAbsolutePath for p1Abs: " + p1Abs.toAbsolutePath());

		System.out.println("subpath of the p1: " + p1.subpath(0, 2));
		System.out.println("subpath of the p1Abs: " + p1Abs.subpath(0, 2));
		//System.out.println("strange index for subpath, p1 path: " + p1.subpath(1, 1));
		//System.out.println("strange index for subpath, p1 path: " + p1.subpath(-1, 2));
		//System.out.println("strange index for subpath, p1 path: " + p1.subpath(0, 4));

		Path pBird = Paths.get("bird");
		Path pFish = Paths.get("fish");
		System.out.println(pBird.relativize(pFish));
		System.out.println(pFish.relativize(pBird));	

		Path p2 = Paths.get("/one/two");
		Path p3 = Paths.get("/three");
		Path p4 = Paths.get("four");
		System.out.println("p2.relativize(p3): " + p2.relativize(p3));
		System.out.println("p3.relativize(p2): " + p3.relativize(p2));
		System.out.println("p4.relativize(p3): " + p4.relativize(p3));

	}

	private static void test2(String... args) throws java.net.URISyntaxException {
		Path p1 = Paths.get("/Users/antonelpazargic/jtonic/git/github/certifications-ocp8/src/ro/jtonic/cert/ocp8/ch9/dir1/Test2.txt");
		Path p2 = Paths.get("./Test.txt");
		Path p3 = Paths.get("Test1.txt");
		Path p4 = Paths.get("./dir1", "Test3.txt");
		Path p5 = Paths.get(new URI("file:///Users/antonelpazargic/jtonic/git/github/certifications-ocp8/src/ro/jtonic/cert/ocp8/ch9/dir1"));
		
		// the following path declaration doesn't work because there is a missing / in file://
		// the runtime exception thrown is java.lang.IllegalArgumentException: URI has an authority component.
		// the URI must reference an absolute path in file system.
		// Path p6 = Paths.get(new URI("file://Users/antonelpazargic/jtonic/git/github/certifications-ocp8/src/ro/jtonic/cert/ocp8/ch9/dir1"));
		// Path p7 = Paths.get(new URI("http://wiley.com"));

		FileSystem fs = FileSystems.getDefault();
		System.out.println("Default file system: " + fs);		
		Path p8 = FileSystems.getDefault().getPath("PathTest.java");

		System.out.println("Path p1: " + p1);
		System.out.println("Path p2: " + p2);
		System.out.println("Path p3: " + p3);
		System.out.println("Path p4: " + p4);
		System.out.println("Path p5: " + p5);
		// System.out.println("Path p7: " + p7);
		System.out.println("Path p8: " + p8);

		System.out.println("Normalized absolute paths....");
		System.out.println("Path p1: " + p1.toAbsolutePath().normalize());
		System.out.println("Path p2: " + p2.toAbsolutePath().normalize());
		System.out.println("Path p3: " + p3.toAbsolutePath().normalize());
		System.out.println("Path p4: " + p4.toAbsolutePath().normalize());
		System.out.println("Path p5: " + p5.toAbsolutePath().normalize());
		System.out.println("Path p8: " + p8.toAbsolutePath().normalize());
		System.out.println("path to uri: " + p5.toUri());
			
		// FileSystem fsHttp = FileSystems.getFileSystem(new URI("http://www.selikoff.net"));	
		// System.out.println("http://www.selikoff.net file system: " + fsHttp);
		// Path p9 = fsHttp.getPath("duck.txt");

		File f8 = p8.toFile();
		System.out.println("File instance for Path p8: " + f8);
		System.out.println("Back to Path instance, from file instance: " + f8.toPath());

		Path p10 = FileSystems.getDefault().getPath("./Kkkmk.java");
		System.out.println("Path p10: " + p10);
		try {
			System.out.println("p10.toRealPath(): " + p10.toRealPath());
		} catch (java.io.IOException exc) {
			exc.printStackTrace();
		}
	
		Path p11 = Paths.get("/land/hippo/harry.happy");
	
	}

}
