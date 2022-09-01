package com.example.demo.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

	@Autowired
	BoardMapper mapper;
	
	@GetMapping("/board/index.do")
	public String index(Model model) {
		model.addAttribute("list", mapper.list());
		return "board/index";
	}
}
