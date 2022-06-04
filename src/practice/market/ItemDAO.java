package practice.market;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ItemDAO {

	Connection conn = null;
	
	public ItemDAO() {
		try {
			// 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"testuser", 
					"test1234");
			
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (conn != null) try { conn.close();} catch (Exception e) {}
		}
		System.out.println("데이터베이스 접속");
	}
	
	public int insert(ItemVO vo) {
		int result = 0;
		
		return result;
	}
}
