package chap04;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {
	int selectCount(BoardDTO dto);
	List<BoardDTO> selectList(BoardDTO dto);
	int insert(BoardDTO dto);
}
