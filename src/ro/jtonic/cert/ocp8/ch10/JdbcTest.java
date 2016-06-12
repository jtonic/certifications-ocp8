
import java.sql.*;

public final class JdbcTest {

	public static void main(String... args) throws SQLException {
		String url = "jdbc:mysql://localhost/ch10";
		try (	
			Connection con = DriverManager.getConnection(url, "ch10", "ch10");
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select id, name, num_acres from species");
		) {
			while(rs.next()) {
				System.out.println("id = " + rs.getInt(1) + ", name = " + rs.getString("name") + ", num_acres = " + rs.getDouble("num_acres"));
			}
		}
	}
}
