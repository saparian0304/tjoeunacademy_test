package user;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
	
	public List<Map<String, Object>> list() {
//		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();  // 이렇게 해도 된다.
		List<Map<String, Object>> list = new ArrayList();
		
		String sql = "SELECT * FROM users ORDER BY userno DESC";
		
		try {
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Map<String, Object> map = new HashMap();
				map.put("userno", rs.getInt("userno"));
				map.put("name", rs.getString("name"));
				map.put("email", rs.getString("email"));
				map.put("tel", rs.getString("tel"));
				map.put("regidate", rs.getString("regidate"));
				list.add(map);
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list; 
	}
	
	public Map<String, Object> view(int userno) {
		Map<String, Object> map = new HashMap();
		try {
			String sql = "SELECT * FROM users WHERE userno =? ";
			
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, userno);
			rs = psmt.executeQuery();
			
			if (rs.next()) {
				map.put("userno", rs.getInt("userno"));
				map.put("name", rs.getString("name"));
				map.put("email", rs.getString("email"));
				map.put("tel", rs.getString("tel"));
				map.put("regidate", rs.getString("regidate"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	public List<Map<String, Object>> hobbyList(int userno) {
		List<Map<String, Object>> list = new ArrayList();
		
		String sql = "SELECT * FROM hobby WHERE userno = ? ORDER BY hobbyno";
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, userno);
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				Map<String, Object> map = new HashMap();
				map.put("name", rs.getString("name"));
				list.add(map);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public List<Map<String, String>> hobby(int userno) {
		List<Map<String, String>> list = new ArrayList();
		
		String sql = "SELECT ";
		
		
		return list;
	}
	
}
