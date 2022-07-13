package chap06;

import java.util.List;

public interface BoardMapper {
//	@Select("SELECT * FROM tb1_board WHERE bno > 0")
	List<BoardVO> getList();
	List<BoardVO> getListWithPaging(Criteria cri);
	
	void insert(BoardVO board);			// PK가 필요 없는 경우
	void insertSelectKey(BoardVO board);// PK가 필요한 경우
	// read
	BoardVO read(long bno);
	// delete
	int delete(long bno);
	
	// update
	int update(BoardVO board);
	
	public int getTotalCount(Criteria cri);
}
