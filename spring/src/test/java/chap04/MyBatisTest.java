package chap04;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config/root-context.xml")
//@ContextConfiguration("file:src/main/resources/config/root-context.xml")
@Log4j
public class MyBatisTest {

	@Autowired
	BoardDAO dao;
	
	@Autowired
	BoardMapper mapper;
	
//	@Test
	public void selectCount2() {
		BoardDTO dto = new BoardDTO();
//		dto.setSearchWord("11");
//		dto.setSearchField("title");
		dto.setSearchDate("2022-06-15");
		String[] nums = {"368", "369", "370", "371"};
		dto.setNums(nums);
		int count = mapper.selectCount(dto);
		log.info("여기는 매퍼");
		log.info(count);
	}
	
//	@Test
	public void selectCount() {
		BoardDTO dto = new BoardDTO();
//		dto.setSearchWord("11");
//		dto.setSearchField("title");
		dto.setSearchDate("2022-06-15");
		String[] nums = {"368", "369", "370", "371"};
		dto.setNums(nums);
		int count = dao.selectCount(dto);
		log.info(count);
	}
	
//	@Test
	public void selectList() {
		BoardDTO dto2 = new BoardDTO();
		dto2.setSearchWord("지금은");
		dto2.setSearchField("title");
		dto2.setSearchDate("2022-06-14");
		List<BoardDTO> list = dao.selectList(dto2);
		for (BoardDTO dto : list) {
			System.out.println(dto.getSubject() + "\t" + dto.getPostdate());
		}
	}

//	@Test
	public void insert() {
		BoardDTO dto = new BoardDTO();
		dto.setTitle("널값 오류시 테스트 한번 더");
		dto.setContent("setting");
		dto.setId("test1");
		int result = dao.insert(dto);
		log.info("등록결과 : " + result);
	}
	@Test
	public void insert1() {
		BoardDTO dto = new BoardDTO();
		dto.setTitle("selectkey1");
		dto.setContent("setting");
		dto.setId("test1");
		int result = mapper.insert(dto);
		log.info("등록결과 : " + result);
		log.info("num값 : " + dto.getNum());
	}
	
	@Test
	public void updateDelete() {
		BoardDTO dto = new BoardDTO();
		dto.setTitle("페이징 처리2");
		dto.setContent("페이징 처리2");
		dto.setNum(368);
		log.info("수정개수: " + dao.update(dto));
	}
}
