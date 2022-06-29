package org.zerock.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		// /WEB-INF/views/home.jsp
		return "home";
	}
	
	@GetMapping("/gallery/index")
	public String galleryIndex(HttpServletRequest req, MemberDTO dto) {
		// 매개변수로 MemberDTO를 사용 
		// "name=김길동"이라는 파라미터를 담아 요청=> MemberDTO라는 클래스가 스캔되면 알아서 게터/세터 메서드를 찾아서 입력시켜준다.
		System.out.println(dto.getName());
		req.setAttribute("name", "홍길동");
//		req.setAttribute("name", dto.getName());
		
		// /WEB-INF/views/gallery/index.jsp
		return "gallery/index";
	}
}
