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
	
	public List<BoardDTO> selectListPage(Map<String, Object> map) {
		List<BoardDTO> bbs = new Vector<BoardDTO>();
		
		// 쿼리문 템플릿
		String query = "SELECT * FROM "
						+ "(SELECT tb.*, ROWNUM rNum "
						+ " FROM ( SELECT * FROM board LEFT JOIN member ON board.id = member.id ";
		
		// 검색 조건 추가
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
		
		query  += "	 		ORDER BY num DESC ) "
				+ "		tb ) "
				+ " WHERE rNum BETWEEN ? AND ?";
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, map.get("start").toString());
			psmt.setString(2, map.get("end").toString());
			
			rs = psmt.executeQuery();
			
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
					+ " num, title, content, id, postdate, visitcount, sfile, ofile)" 
					+ " VALUES ( "
					+ " seq_board_num.NEXTVAL, ?, ?, ?, sysdate, 0, ?, ?)";
			
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getContent());
			psmt.setString(3, dto.getId());
			psmt.setString(4, dto.getSfile());
			psmt.setString(5, dto.getOfile());
			
			result = psmt.executeUpdate();
		}
		catch (Exception e) {
			System.out.println("게시물 입력 중 예외 발생");
			e.printStackTrace();
		}
		
		return result;
	}
	
	public BoardDTO selectView(String num) {
		BoardDTO dto = new BoardDTO();
		
		String query = "SELECT B.*, M.name " 
					+ " FROM member m INNER JOIN board B "
					+ " ON M.id = B.id "
					+ " WHERE num=?";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, num);
			rs = psmt.executeQuery();
			
			if (rs.next()) {
				dto.setNum(rs.getString(1));
				dto.setTitle(rs.getString(2));
				dto.setContent(rs.getString("content"));
				dto.setPostdate(rs.getDate("postdate"));
				dto.setId(rs.getString("id"));
				dto.setVisitcount(rs.getString(6));
				dto.setName(rs.getString("name"));
				dto.setOfile(rs.getString("ofile"));
				dto.setSfile(rs.getString("sfile"));
			}
		}
		catch (Exception e) {
			System.out.println("게시물 상세보기 중 예외 발생");
			e.printStackTrace();
		}
		
		return dto;
	}
	
	public void updateVisitCount(String num) {
		
		String query = "UPDATE board SET "
					+ " visitcount = visitcount + 1 "
					+ " WHERE num=?";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, num);
			psmt.executeQuery();
		}
		catch (Exception e) {
			System.out.println("게시물 조회수 증가 중 예외 발생");
			e.printStackTrace();
		}
	}
	
	public int updateEdit(BoardDTO dto) {
		int result = 0;
		
		try {
			String query = "UPDATE board SET "
						+ " title=?, content=? "
						+ " WHERE num=?";
			
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getContent());
			psmt.setString(3, dto.getNum());

			result = psmt.executeUpdate();
		}
		catch (Exception e) {
			System.out.println("게시물 수정 중 예외 발생");
			e.printStackTrace();
		}
		return result;
	}
	
	public int deletePost(BoardDTO dto) {
		int result = 0;
		
		try {
			String query = "DELETE FROM board WHERE num=?";
			
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getNum());
			
			result = psmt.executeUpdate();
		}
		catch (Exception e) {
			System.out.println("게시물 삭제 중 예외 발생");
			e.printStackTrace();
		}
		return result;
	}
	
}
