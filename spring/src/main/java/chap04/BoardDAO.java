package chap04;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {
	
	@Autowired
	SqlSessionTemplate sst;
	
	public int selectCount(BoardDTO dto) {
//		int totalCount = sst.selectOne("namespace.id", dto);
		// namespace.id 는 매퍼.xml에 등록된 namespace와 id임 
		return sst.selectOne("board.selectCount", dto);
	}
	
	public List selectList(BoardDTO dto) {
		return sst.selectList("board.selectList", dto);
	}
	
	public int insert(BoardDTO dto) {
		return sst.insert("board.insert", dto);
		
	}
}
