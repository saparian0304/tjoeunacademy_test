package kr.co.project.member;

public interface MemberService {

	int insert(MemberVO vo);
	boolean checkEmail(MemberVO vo);
}
