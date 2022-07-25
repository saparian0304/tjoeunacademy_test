package kr.co.project.news;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsServiceImpl implements NewsService {

	@Autowired
	NewsMapper mapper;
	
	@Override
	public List<NewsVO> getList(NewsVO vo) {
		return mapper.getList(vo);
	}

}
