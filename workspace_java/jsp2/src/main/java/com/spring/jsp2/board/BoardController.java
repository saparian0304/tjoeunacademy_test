package com.spring.jsp2.board;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	BoardService service;
	// 인터페이스 형태로 주입받으면 이후 수정사항이 생겼을 때 클래스파일 통째로 옮길 수 있음
	
	@RequestMapping("/index.do")
	public String index(Model model, BoardVO vo) {
		Map map = service.list(vo);
		model.addAttribute("map", map);
		return "board/list";
	}
}
