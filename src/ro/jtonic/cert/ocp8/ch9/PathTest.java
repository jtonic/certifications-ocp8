// package ro.jtonic.cert.ocp8.ch9;

import java.nio.file.*;
import java.nio.file.attribute.*;
import java.util.Locale;

/**
 * Created by antonelpazargic on 04/06/16.
 */
public class PathTest {

    public static void main(String... args) throws java.io.IOException {
        Path p1 = Paths.get("/Users/antonelpazargic/jtonic/git/github/certifications-ocp8/src/ro/jtonic/cert/ocp8/ch9/Test.txt");
        System.out.println("Files.size(p1)= " + Files.size(p1) + " [bytes].");

        UserPrincipal owner = Files.getOwner(p1);
        System.out.println(owner);

        Locale romania = new Locale("ro", "RO");
        Locale.setDefault(romania);
        System.out.println("Default locale= " + Locale.getDefault());

        FileTime time = Files.getLastModifiedTime(p1);
        System.out.println("last modified time= " + time);

	FileSystem fs = FileSystems.getDefault();
	System.out.println("Default file system= " + fs);

	UserPrincipal tutye = null; 
	try {
		tutye = fs.getUserPrincipalLookupService().lookupPrincipalByName("tutye");
	} catch (java.nio.file.attribute.UserPrincipalNotFoundException exc) {
		System.err.println("The OS user tutye doesn't exist");
		throw new RuntimeException(exc);
	}
	System.out.println("tutye as user principal= " + tutye.getName());
    }

}
