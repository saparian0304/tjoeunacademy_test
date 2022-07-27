package org.practice.ajp.chat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ChatController {
	@GetMapping("/chat")
	public String chat(Model model) {
		
		ChatUserVO user = new ChatUserVO();
		user.setName("admin");
		
		log.info("==================================");
		log.info("@ChatController, GET Chat / Username : " + user.getName());
		
		model.addAttribute("user", user.getName());
		
		return "chat/chat";
	}
}
