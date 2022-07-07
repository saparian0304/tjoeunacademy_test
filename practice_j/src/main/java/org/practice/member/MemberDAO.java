package org.practice.member;

import java.util.List;

import org.practice.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	
	@Autowired
	MemberMapper mapper;
	
	public List<MemberVO> list(MemberVO vo) {
		List<MemberVO> list = mapper.selectAll(vo);
		return list;
	}
	
}
