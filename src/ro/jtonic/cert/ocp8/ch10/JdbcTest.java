
import java.sql.*;
import java.time.*;

public final class JdbcTest {

	private static final String URL  = "jdbc:mysql://localhost:3306/ch10";
	public static void main(String... args) throws SQLException {
		test2();

		System.exit(0);

		test1();
	}

	public static void test2() {
		try (	
			Connection con = DriverManager.getConnection(URL, "ch10", "ch10");
			Statement stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stm.executeQuery("select name, date_born, id from animals");
		) {
			if(rs.first()) {
				System.out.println("name: " + rs.getString("name1"));
			}	
		} catch(SQLException e) {
			System.out.println("e.getMessage(): " + e.getMessage());
			System.out.println("e.getSQLState(): " + e.getSQLState());
			System.out.println("e.getErrorCode(): " + e.getErrorCode());
		}
	}

	public static void test1() throws SQLException {
		// Use the following to load the Mysql driver, in case the jdbc provider doesn't offer the /META-INF/services/java.sql.Driver
		// and don't forget to declare java.lang.ClassNotFoundException
		// Class.forName("com.mysql.jdbc.Driver");
		try (	
			Connection con = DriverManager.getConnection(URL, "ch10", "ch10");
			Statement stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stm.executeQuery("select name, date_born, id from animals");
		) {


			if(rs.first()) {
				System.out.print("rs.first: ");
				print(rs);
			}
			
			if(rs.last()) {
				System.out.print("rs.last(): ");
				print(rs);
			}

			rs.afterLast();		
			rs.previous();
			print(rs);

			rs.beforeFirst();
			rs.next();
			print(rs);			

			rs.absolute(2);
			print(rs);

			rs.relative(2);
			print(rs);


			if (rs.absolute(-1)) {
				System.out.print("rs.absolute(-1))");
				print(rs);
			}

			if (rs.relative(-1)) {
				System.out.print("rs.relative(-1)");
				print(rs);
			}

			// The following throws SQLException
			if (rs.absolute(0)) {
					print(rs);
			}

			// there are 6 rows in the table. The following throws SQLException
			if (rs.absolute(7)) {
					print(rs);
			}

			// after the end of the result set
			rs.afterLast();
			print(rs);
			
			// before the firs row
			rs.beforeFirst();
			print(rs);

			// exceeded the rows number;
			rs.relative(3);
			print(rs);
		}
	}

	private static void print(ResultSet rs) throws SQLException {
			System.out.println("Name: " + rs.getObject("name"));
			LocalDateTime birthDate = rs.getTimestamp("date_born").toLocalDateTime();
			System.out.println("Birth date: " + birthDate);
			System.out.println("Id: " + (Integer)rs.getObject("id"));
	}
}
