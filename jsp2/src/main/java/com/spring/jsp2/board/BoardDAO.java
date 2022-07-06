package com.spring.jsp2.board;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {

	@Autowired
	SqlSessionTemplate sst;
	
	public int count(BoardVO vo) {
		return sst.selectOne("board.count", vo);
	}
	
	public List<BoardVO> list(BoardVO vo) {
		return sst.selectList("board.list", vo);
	}
	
}
