package chapter20;

import java.util.List;

public class MemberMain {

	public static void main(String[] args) {
		
		// MemberDAO 객체 생성
		MemberDAO dao = new MemberDAO();	// DB 커넥션 (생성자에 정의되어있음)
		
//		 회원 객체 생성 후 등록
//		MemberVO vo = new MemberVO();
//		vo.setId("Park");
//		vo.setName("박길동");
//		int r = insert(vo, dao);
//		if (r>0) {
//			System.out.println("회원가입 성공");
//		}

		// PreparedStatement
		// 회원 객체 생성 후 등록
		MemberVO vo = new MemberVO();
		vo.setId("Park2");
		vo.setName("박길동2");
		int r = insert2(vo, dao);
		if (r>0) {
			System.out.println("회원가입 성공");
		}

		// 상세 정보 확인하기
//		MemberVO vo = dao.selectOne(2);
//		System.out.println(vo.getMemberno());
//		System.out.println(vo.getId());
//		System.out.println(vo.getName());
		
		// 회원 정보 수정
//		MemberVO vo = new MemberVO();
//		vo.setId("Park");
//		vo.setName("박길동");
//		vo.setMemberno(2);
//		if (dao.update(vo) > 0) {
//			System.out.println("회원 정보 변경");
//		}

		// 회원정보 삭제
//		if (dao.delete(2)>0) {
//			System.out.println("회원 정보 삭제");
//		}
		
		// 회원 목록
		List<MemberVO> list = dao.list();
		for (int i=0; i<list.size(); i++) {
			System.out.println("회원번호 : "+list.get(i).getMemberno()
								+ ", 회원ID : "+list.get(i).getId()
								+ ", 회원이름 : "+list.get(i).getName());
		}
		
		
		dao.close(); 	// 자원 해제
				
	}
	
	static int insert(MemberVO vo, MemberDAO dao) {
		return dao.insert(vo);
	}
	
	// PreparedStatement를 사용한 메서드
	static int insert2(MemberVO vo, MemberDAO dao) {
		return dao.insert2(vo);
	}
	
	

}
