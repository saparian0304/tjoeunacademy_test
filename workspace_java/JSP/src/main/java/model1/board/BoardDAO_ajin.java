package model1.board;

import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.servlet.ServletContext;
import common.JDBConnect;

public class BoardDAO_ajin extends JDBConnect {

	public BoardDAO_ajin(ServletContext application) {
		super(application);
	}

	public int selectCount(Map<String, Object> map) {
		int totalCount = 0;

		String query = "SELECT COUNT(*) from board";
		if (map.get("searchWord") != null) { // 검색했을 경우
			if ("all".equals(map.get("searchField"))) {

				query += " WHERE title like '%" + map.get("searchWord") + "%'" + " or content LIKE '%"
						+ map.get("searchWord") + "%'";
			} else {
				query += " where " + map.get("searchFiedl") + " " + " like '%" + map.get("searchWord") + "%'";
			}
		}
		
		try {
			stmt = con.createStatement(); // count(*)은 무조건 결과값있음. 따라서 if문 안써줘도 됨.
			rs = stmt.executeQuery(query);
			rs.next();
			totalCount = rs.getInt(1);
		} catch (Exception e) {
			System.out.println("게시물 수를 구하는 중 예외 발생");
			e.printStackTrace();
		}
		return totalCount;
	}

	public List<BoardDTO> selectList(Map<String, Object> map) {
		List<BoardDTO> bbs = new Vector<BoardDTO>();

		String query = "SELECT * FROM board bo LEFT OUTER JOIN member mb on bo.id = mb.id";

		if (map.get("searchWord") != null) {
			if ("all".equals(map.get("searchField"))) {

				query += " WHERE title like '%" + map.get("searchWord") + "%'" + " or content LIKE '%"
						+ map.get("searchWord") + "%'";
			} else {
				query += " where " + map.get("searchFiedl") + " " + " like '%" + map.get("searchWord") + "%'";
			}
		}
		query += " ORDER BY num DESC ";

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
		} catch (Exception e) {
			System.out.println("게시물 조회 중 예외 발생");
			e.printStackTrace();
		}
		return bbs;
	}

	public List<BoardDTO> selectListPage(Map<String, Object> map) {
		List<BoardDTO> bbs = new Vector<BoardDTO>();

		String query = "SELECT * FROM ( " + "   select Tb.*, ROWNUM rNum from ( "
				+ "       select * from board bo left join member mb on bo.id=mb.id";

		if (map.get("searchWord") != null) { //검색했을 경우
			if("all".equals(map.get("searchField"))) {
				query += " WHERE title like '%" + map.get("searchWord") +"%'"
			          + " or content LIKE '%" + map.get("searchWord") + "%'";
				
			}else {
				query +=" WHERE " +map.get("searchField") +" like '%" + map.get("searchWord") +"%'"; 
						
			}
		}
		query += " ORDER BY num DESC " + "   )Tb " + " ) " + " where rNum between ? and ?";
		
		System.out.println(map.get("searchField"));
		System.out.println(map.get("searchWord"));
		System.out.println(query);
		
		
		
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
		} catch (Exception e) {
			System.out.println("게시물 조회 중 예외 발생");
			e.printStackTrace();
		}
		return bbs;
	}

	public int insertWrite(BoardDTO dto) {
		int result = 0;

		try {
			String query = "INSERT INTO board ( " + " num,id,title,content,visitcount) " + " VALUES ( "
					+ " seq_board_num.NEXTVAL, ?, ?, ?, 0)";
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getTitle());
			psmt.setString(3, dto.getContent());
			System.out.println(psmt.getResultSet());
			result = psmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("게시물 입력 중 예외 발생");
			e.printStackTrace();
		}
		return result;
	}

	public BoardDTO selectView(String num) {
		BoardDTO dto = new BoardDTO();

		String query = "select B.*, M.name" + " from member M inner join board B " + " on M.id=B.id " + " where num=?";

		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, num);
			rs = psmt.executeQuery();

			if (rs.next()) {
				dto.setNum(rs.getString(1));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString("content"));
				dto.setPostdate(rs.getDate("postdate"));
				dto.setId(rs.getString("id"));
				dto.setVisitcount(rs.getString(6));
				dto.setName(rs.getString("name"));
			}
		} catch (Exception e) {
			System.out.println("게시물 상세보기 중 예외 발생");
			e.printStackTrace();
		}
		return dto;
	}

	public void updateVisitCount(String num) {
		String query = "UPDATE board SET " + " visitcount=visitcount+1" + " WHERE num=?";

		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, num);
			psmt.executeQuery();
		} catch (Exception e) {
			System.out.println("게시물 조회수 증가 중 예외 발생");
			e.printStackTrace();
		}
	}

	public int updateEdit(BoardDTO dto) {
		int result = 0;
		try {
			String query = "update board set" + " title=?, content=? " + " where num=?";

			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getContent());
			psmt.setString(3, dto.getNum());

			result = psmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("게시물 수정 중 예외 발생");
			e.printStackTrace();
		}
		return result;
	}

	public int deletePost(BoardDTO dto) {
		int result = 0;
		try {
			String query = "delete from board where num=?";

			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getNum());

			result = psmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("게시물 삭제 중 예외 발생");
			e.printStackTrace();
		}
		return result;
	}

}
