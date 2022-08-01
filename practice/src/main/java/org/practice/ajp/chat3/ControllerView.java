package org.practice.ajp.chat3;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Controller
public class ControllerView {

	// 채팅방 입장
	@RequestMapping("/chat.do")
	public String view_chat(HttpServletRequest req, HttpServletResponse res, Model model) {
		return "chat3/view";
	}
	
	
	
}
