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
		MemberDTO dto = new MemberDTO();
		try {
			String sql = "SELECT * FROM member";
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				if (rs.getString("id")==id && rs.getString("pass") == pwd) {
					dto.setId(id);
					dto.setPwd(pwd);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(dto.getId());
		
		return dto;
	}
	
	public void close() {
		try {
			rs.close();
			psmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
