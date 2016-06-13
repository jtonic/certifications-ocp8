
import java.sql.*;
import java.time.*;

public final class JdbcTest {

	public static void main(String... args) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/ch10";
		// Use the following to load the Mysql driver, in case the jdbc provider doesn't offer the /META-INF/services/java.sql.Driver
		// and don't forget to declare java.lang.ClassNotFoundException
		// Class.forName("com.mysql.jdbc.Driver");
		try (	
			Connection con = DriverManager.getConnection(url, "ch10", "ch10");
			Statement stm = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stm.executeQuery("select name, date_born, id from animals");
		) {
			if (rs.next()) {
					System.out.println(rs.getTime(2).toLocalTime());
					System.out.println(rs.getDate(2).toLocalDate());
					System.out.println(rs.getTimestamp(2).toLocalDateTime());

					LocalDateTime birthDate = ((Timestamp) rs.getObject("date_born")).toLocalDateTime();
					System.out.println("birth date = " + birthDate);
			}
		}
	}
}
