package model2.mvcboard;

import common.DBConnPool;

public class AddfileDAO extends DBConnPool {
	
	public int insertFile(AddFileDTO dto) {
		int result =0;
		
		int f_idx = 0;
		
		String query = "SELECT nvl(max(f_idx), 0)+1 as f_idx FROM addfile";
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			rs.next();
			f_idx = rs.getInt("f_idx");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int board_idx = 0;
		
		query = "SELECT nvl(max(idx), 0) as board_idx FROM mvcboard";
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			rs.next();
			board_idx = rs.getInt("board_idx");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (f_idx > 0) {
			query = "INSERT INTO addfile (f_idx, board_idx, ofile, sfile) VALUES (?, ?, ?, ?)";
			
			try {
				psmt = con.prepareStatement(query);
				psmt.setInt(1, f_idx);
				psmt.setInt(2, board_idx);
				psmt.setString(3, dto.getOfile());
				psmt.setString(4, dto.getSfile());
				
				result = psmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int deleteFile(int idx) {
		int result = 0;
		
		String sql = "DELETE FROM addfile WHERE F_idx = ?";
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, idx);
			
			result = psmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
