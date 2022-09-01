package calendar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DateInsert {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root1234");
			stmt = conn.createStatement();
			
			for (int i=0; i<1000; i++) {
				stmt.executeUpdate("Insert into calendar values ('"+DateUtil.getAddDate("2022-01-01", i)+"')");
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			if (stmt != null) try { stmt.close(); } catch (Exception e) {}
			if (conn != null) try { conn.close(); } catch (Exception e) {}
		}
	}

}
