package org.board.game;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class GameController  {
	
	@Autowired
	GameService service;
	
	// 게임 시작 URL
	@RequestMapping("/omok.do")
	public String entryGame(HttpSession sess, Model model, GameDTO dto) {
		sess.invalidate(); 
		model.addAttribute("game", dto.getGame());
		
		return "board";
	}
	
	// ajax 통신관련
	@RequestMapping("/omok/stone.do")
	public void checkOmok(GameDTO dto, HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		resp.setContentType("text/html; charset=UTF-8");
				
		PrintWriter out = resp.getWriter();
		out.print(service.check(dto, req, resp));
	}
	
	
	@RequestMapping()
	public String index() {
		return "index";
	}
}
