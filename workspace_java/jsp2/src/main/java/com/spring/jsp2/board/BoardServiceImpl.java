package com.spring.jsp2.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.jsp2.util.BoardPage;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardDAO dao;
	
	@Override
	public Map list(BoardVO vo) {
		int totalCount = dao.count(vo);
		List<BoardVO> list = dao.list(vo);
		
		String pagingImg = BoardPage.pagingStr(totalCount, vo.getPageSize(), vo.getBlockSize(), vo.getPageNum(), "index.do");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pagingImg", pagingImg);
		map.put("totalCount", totalCount);
		map.put("pageSize", vo.getPageSize());
		map.put("pageNum", vo.getPageNum());
		map.put("boardLists", list);
		
		map.put("searchField", vo.getSearchField());
		map.put("searchWord", vo.getSearchWord());
		
		return map;
	}

}
