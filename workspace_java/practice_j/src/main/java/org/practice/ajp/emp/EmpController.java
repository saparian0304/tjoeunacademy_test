package org.practice.ajp.emp;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/emp")
public class EmpController {
	@Autowired
	EmpService service;
	
	@RequestMapping("/list.do")
	public String empList(Model model, EmpVO vo) {
		Map map = service.list(vo);
		model.addAttribute("map", map);
		
		return "emp/empList";
	}
}
