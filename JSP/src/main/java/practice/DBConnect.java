package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnect {
	Connection con = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	
	public DBConnect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
					"testuser",
					"test1234");
			System.out.println("연결 성공");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// DB에 원하는 멤버DTO 찾아오기 작성중
	public MemberDTO select(String id, String pwd) {
		
		try {
			String sql = "SELECT * FROM member";
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				if (rs.getString("id")==id && rs.getString("pass") == pwd) {
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
