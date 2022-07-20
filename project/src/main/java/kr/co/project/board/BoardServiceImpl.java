package kr.co.project.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardMapper mapper;
	
	@Override
	public Map index(BoardVO vo) {
		int totalCount = mapper.getTotalCount(vo);	// 총 게시물 수
		// 총 페이지 수
		int totalPage = totalCount / vo.getRowPerPage();	
		if (totalCount % vo.getRowPerPage() > 0) totalPage++;
		
		// 시작 인덱스
		int startIdx = (vo.getPage()-1) * vo.getRowPerPage();
		vo.setStartIdx(startIdx);
		
		List<BoardVO> list = mapper.getList(vo);
		
		Map map = new HashMap();
		map.put("page", vo.getPage());
		map.put("totalCount", totalCount);
		map.put("totalPage", totalPage);
		map.put("list", list);
		map.put("paging", new BoardPageDTO(vo, totalCount));
		return map;
	}

	@Override
	public BoardVO view(int no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardVO edit(int no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(BoardVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int no) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insert(BoardVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

}
