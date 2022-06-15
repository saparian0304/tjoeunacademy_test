package model1.board;

import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.servlet.ServletContext;

import common.JDBConnect;

public class BoardDAO extends JDBConnect {
	
	// 생성자
	public BoardDAO(ServletContext application) {
		super(application);
	}
	
	// 검색 조건에 맞는 게시물의 개수를 반환
	public int selectCount(Map<String, Object> map) {
		int totalCount = 0;
		
		// 게시물 수를 얻어오는 쿼리문 작성
		String query = "SELECT count(*) as cnt FROM board LEFT JOIN member ON board.id = member.id ";
		if (map.get("searchWord") != null) {
			if ("titlecontent".equals(map.get("searchField"))) {
				query += " WHERE  title "
						+ "LIKE '%" + map.get("searchWord") + "%' "
						+ " OR content LIKE '%" + map.get("searchWord") + "%' ";
			} else {
				query += " WHERE " + map.get("searchField") + " "
						+ "LIKE '%" + map.get("searchWord") + "%' ";
			}
		}
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			rs.next();	// count(*) 는 결과값이 항상 있어서 if문이 필요 없음
			totalCount = rs.getInt("cnt");
		} 
		catch (Exception e) {
			System.out.println("게시물 수를 구하는 중 예외 발생");
			e.printStackTrace();
		}
		
		return totalCount;
	}
	
	// 검색 조건에 맞는 게시물 목록 반환
	public List<BoardDTO> selectList(Map<String, Object> map) {
		List<BoardDTO> bbs = new Vector<BoardDTO>();
		
		String query = "SELECT * FROM board LEFT JOIN member ON board.id = member.id ";
		if (map.get("searchWord") != null) {
			if ("titlecontent".equals(map.get("searchField"))) {
				query += " WHERE  title "
						+ "LIKE '%" + map.get("searchWord") + "%' "
						+ " OR content LIKE '%" + map.get("searchWord") + "%' ";
			} else {
				query += " WHERE " + map.get("searchField") + " "
						+ "LIKE '%" + map.get("searchWord") + "%' ";
			}
			query += " ORDER BY num DESC";
		}
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				
				BoardDTO dto = new BoardDTO();
				
				dto.setNum(rs.getString("num"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setPostdate(rs.getDate("postdate"));
				dto.setId(rs.getString("id"));		
				dto.setName(rs.getString("name"));		
				dto.setVisitcount(rs.getString("visitcount"));
				
				bbs.add(dto);
			}
		}
		catch (Exception e) {
			System.out.println("게시물 조회 중 예외 발생");
			e.printStackTrace();
		}
		
		return bbs;
	}
	
	public int insertWriter(BoardDTO dto) {
		
		int result = 0;
		
		try {
			// INSERT 쿼리문 작성
			String query = "INSERT INTO BOARD ( " 
					+ " num, title, content, id, postdate, visitcount)" 
					+ " VALUES ( "
					+ " seq_board_num.NEXTVAL, ?, ?, ?, sysdate, 0)";
			
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getContent());
			psmt.setString(3, dto.getId());
			
			result = psmt.executeUpdate();
		}
		catch (Exception e) {
			System.out.println("게시물 입력 중 예외 발생");
			e.printStackTrace();
		}
		
		return result;
	}
	
}
