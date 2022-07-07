package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVO;

public interface BoardMapper {
//	@Select("SELECT * FROM tb1_board WHERE bno > 0")
	List<BoardVO> getList();
	
	void insert(BoardVO board);			// PK가 필요 없는 경우
	void insertSelectKey(BoardVO board);// PK가 필요한 경우
	// read
	BoardVO read(long bno);
	// delete
	int delete(long bno);
	
	// update
	int update(BoardVO board);
}
