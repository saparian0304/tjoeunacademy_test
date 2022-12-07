package com.example.sns.post;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PostMapper {

	int insert(PostVO vo);
	int bulkInsert(List list);
}
