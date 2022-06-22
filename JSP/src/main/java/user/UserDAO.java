package user;

import java.sql.SQLException;
import java.util.Map;

import common.DBConnPool;

public class UserDAO extends DBConnPool {
	
	public int insert(Map<String, Object> map) throws SQLException {
		
		String sql = "select nvl(max(userno), 0) +1 as userno from users";
		stmt = con.createStatement();
		rs = stmt.executeQuery(sql);
		rs.next();
		int userno = rs.getInt("userno");
		
		sql = "INSERT INTO users (userno, name, email, tel, regidate) VALUES (?,?,?,?, sysdate)";
		
		psmt = con.prepareStatement(sql);
		psmt.setInt(1, userno);
		psmt.setString(2, (String)map.get("name"));
		psmt.setString(3, (String)map.get("email"));
		psmt.setString(4, (String)map.get("tel"));
		
		psmt.executeUpdate();
		
		// 취미 등록
		
		return userno;
	}
	
	public int insertHobby(int userno, String name) {
		int result = 0;
		try {
			String sql = "select nvl(max(hobbyno), 0) +1 as hobbyno from hobby";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			rs.next();
			int hobbyno = rs.getInt("hobbyno");
			
			sql = "INSERT into hobby(hobbyno, name, userno) VALUES (?, ?, ?)";
			
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, hobbyno);
			psmt.setString(2, name);
			psmt.setInt(3, userno);
			result = psmt.executeUpdate();
		} catch (Exception e) { e.printStackTrace(); }
		
		return result;
	}
}
