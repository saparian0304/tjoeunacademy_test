package com.example.sns.member;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface MemberMapper {

	int insert(MemberVO vo);
	int update(MemberVO vo);
	MemberVO login(Map map);
	MemberVO getMember(int no);
	
}
