package chapter20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
/*
DB 접속 단계
1. 드라이버(클래스) 로드
2. 연결(connection) 
 - 연결에 필요한 정보 : 호스트, 포트, 아이디, 비밀번호
3. Statement(or PreparedStatement) 객체 생성
4. Statement 객체로 sql 실행
5. 실행 결과를 받아옴
6. 자원해제


*/
	
	
	// 데이터베이스 접속 객체
	Connection conn = null;		// 커넥션 객체(DB 연결)
	Statement stmt = null;		// sql 실행하기 위한 객체
	ResultSet rs = null;		// sql 실행한 결과가 담기는 객체 (select 결과)
	PreparedStatement pstmt = null;
	
	// 생성자
	// 객체 생성과 동시에 데이터베이스 접속
	public MemberDAO() {
		
		try {
			// Mysql 드라이버 로드
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 데이터베이스 접속 -> 
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/javadb",	// Host정보, 포트번호, DB명
					"root",			// 사용자
					"root1234");	// 암호
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	// 데이터 입력
	public int insert(MemberVO vo) {
		
		int result = 0;
		try {
			// sql문
			String sql = "INSERT INTO member (id, name) " 
				+ "VALUES ( '" + 
					vo.getId() + "', '" + 
					vo.getName()+"')";
			// Statement 객체 생성 (SQL을 실행하기 위해서)
			stmt = conn.createStatement();		 
			// SQL 실행 
			// executeUpdate() : insert / delete / update -> 변형된 개수 리턴
			// 예) 1개가 입력되면 1 리턴, 3개가 삭제되면 3 리턴 ... 등
			// executeQuery() : select -> ResultSet 객체 리턴
			result = stmt.executeUpdate(sql);	
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return result;
	}

	// PreparedStatement
	public int insert2(MemberVO vo) {
		
		int result = 0;
		try {
			// sql문
			String sql = "INSERT INTO member (id, name) VALUES (?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getName());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return result;
	}
	
	// 데이터 조회
	// PK(memberno)로 조회한 한 건을 MemberVO 객체에 담아서 리턴
	public MemberVO selectOne(int memberno) {
		MemberVO vo = new MemberVO();
		try {
			String sql = "SELECT * FROM member WHERE memberno=" + memberno;
			stmt = conn.createStatement();
			// executeQuery() : select -> ResultSet 객체 리턴
			rs = stmt.executeQuery(sql);	// 결과 1건 -> PK로 조회하기때문
			
			if (rs.next()) {	// 커서 이동 (있으면 true 리턴) -> next를 안하면 값을 찾을 수 없음
				vo.setMemberno(rs.getInt("memberno"));
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return vo;
	}
	
	// 데이터 수정
	// 회원정보(MemberVO 객체)를 입력받아 DB수정 후 결과 리턴
	public int update(MemberVO vo) {
		
		int result = 0;
		
		try {
			String sql = "UPDATE member SET id='" + 
					vo.getId() + "', name='" + vo.getName() + "' " +
					"WHERE memberno=" + vo.getMemberno();
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return result;
	}
	
	// 데이터 삭제
	// PK(memberno)를 입력받아서 DB에서 삭제 후 결과 리턴
	public int delete(int memberno) {
		
		int result = 0;
		try {
			String sql = "DELETE FROM member WHERE memberno=" + memberno;
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return result;
	}
	
	// 회원 목록
	public List<MemberVO> list() {
			List<MemberVO> list = new ArrayList<MemberVO>();
			
			try {
				String sql = "SELECT * FROM member";
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				
				while (rs.next()) {
					MemberVO vo = new MemberVO();
					vo.setMemberno(rs.getInt("memberno"));
					vo.setId(rs.getString("id"));
					vo.setName(rs.getString("name"));
					list.add(vo);
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			
			return list;
	}
	
	// 자원 close()
	public void close() {
		if (conn != null) {
			try { conn.close(); } catch (SQLException e) {}
		}
		if (stmt != null) {
			try { stmt.close(); } catch (SQLException e) {}
		}
		if (rs != null) {
			try { rs.close(); } catch (SQLException e) {}
		}
	}
}
