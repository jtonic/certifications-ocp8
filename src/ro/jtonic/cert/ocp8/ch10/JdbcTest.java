
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
			boolean isResultSet = stm.execute("select id, name, num_acres from species");
			if (isResultSet) {	
				ResultSet rs = stm.getResultSet();
				System.out.println("A query was executed");
				System.out.println("=================");
				while (rs.next()) {
					System.out.println(rs.getString(2));
				}
			} else {
				int affectedRows = stm.getUpdateCount();
				System.out.println("The affected rows: " + affectedRows);
			}
		}
	}
}
