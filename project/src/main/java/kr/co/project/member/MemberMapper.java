package kr.co.project.member;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

	int insert(MemberVO vo);
	int checkEmail(MemberVO vo);
}
