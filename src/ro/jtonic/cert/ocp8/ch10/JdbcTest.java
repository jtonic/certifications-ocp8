
import java.sql.*;

public final class JdbcTest {

	public static void main(String... args) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/ch10";
		// Use the following to load the Mysql driver, in case the jdbc provider doesn't offer the /META-INF/services/java.sql.Driver
		// and don't forget to declare java.lang.ClassNotFoundException
		// Class.forName("com.mysql.jdbc.Driver");
		try (	
			Connection con = DriverManager.getConnection(url, "ch10", "ch10");
			Statement stm = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
		) {
			int updateCount = stm.executeUpdate("insert into species (name, num_acres) values ('Snake', 1.3)");
			System.out.println("update count: " + updateCount);		
		}
	}
}
