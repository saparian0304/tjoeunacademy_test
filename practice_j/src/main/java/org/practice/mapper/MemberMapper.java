package org.practice.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.practice.member.MemberVO;

@Mapper
public interface MemberMapper {

	@Select("SELECT * FROM p_member")
	List<MemberVO> selectAll(MemberVO vo);
}
