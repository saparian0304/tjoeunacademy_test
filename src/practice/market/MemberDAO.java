package practice.market;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {
	Connection conn = null;
	PreparedStatement pstat = null;
	ResultSet rs = null;
	
	public MemberDAO() {
		try {
			// 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"testuser", 
					"test1234"
					);
		} catch (SQLException e) {
			e.getMessage();
		} catch (ClassNotFoundException e) {
			e.getMessage();
		}
	}
}
