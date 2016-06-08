import java.nio.file.*;

public final class Test20 {
	public static void main(String... args) {
		Path p = Paths.get(".").normalize();
		System.out.println(p);
		System.out.println("p name count: " + p.getNameCount());
	int count = 0;
		for(int i = 0; i < p.getNameCount(); i++
) {
		count++;
	}
	System.out.println(count);
	}
}
