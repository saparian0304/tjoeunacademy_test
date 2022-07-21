package kr.co.project.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {
	
	@Autowired
	BoardService service;
	
	@RequestMapping("/board/index.do")
	public String index(Model model, BoardVO vo) {
		model.addAttribute("data", service.index(vo));
		return "board/index";
	}
	
	@GetMapping("/board/write.do")
	public String write() {
		return "board/write";
	}
	
	@PostMapping("board/insert.do")
	public String insert(BoardVO vo, Model model) {
		if (service.insert(vo)) { 
			model.addAttribute("msg", "정상적으로 저장되었습니다.");
			model.addAttribute("url", "index.do");
			return "common/alert";
		} else {
			model.addAttribute("msg", "저장에 실패했습니다.");
			return "common/alert";
		}
	}
	
	@GetMapping("board/view.do")
	public String view(BoardVO vo, Model model) {
		model.addAttribute("data", service.view(vo.getNo()));
		return "board/view";
	}
	
	@GetMapping("/board/edit.do")
	public String edit(BoardVO vo, Model model) {
		BoardVO data = service.edit(vo.getNo());
		model.addAttribute("data", data);
		return "board/edit";
	}
	
	@PostMapping("/board/update.do")
	public String update(BoardVO vo, Model model) {
		if (service.update(vo)) {
			model.addAttribute("msg", "정상적으로 수정되었습니다.");
			model.addAttribute("url", "view.do?no="+vo.getNo());
			return "common/alert";
		} else {
			model.addAttribute("msg", "수정 실패");
			return "common/alert";
		}
	}
	@GetMapping("/board/delete.do")
	public String delete(BoardVO vo, Model model) {
		if (service.delete(vo.getNo())) {
			model.addAttribute("msg", "정상적으로 삭제되었습니다.");
			model.addAttribute("url", "index.do");
			return "common/alert";
		} else {
			model.addAttribute("msg", "삭제 실패");
			return "common/alert";
		}
	}
}
