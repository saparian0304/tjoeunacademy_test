package chap05;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/param")
public class ParamController {
	
//	@GetMapping("/form.do")
//	public String form() {
//		return "form";
//	}
	
	/*
	 * 파라미터를 받는 4가지 방법
	 * 1. HttpServletRequest 객체 이용
	 * 2. @RequestParam 이용
	 * 3. 커맨드 객체(ModelAttribute) 이용
	 * 4. @PathVariable
	 */
	// 1. HttpServletRequest 객체 이용
	@RequestMapping("/submit.do")
	public void submit(HttpServletRequest req, 
			@RequestParam(name = "name", required=false) String name2,
			@RequestParam(name="num", required=false, defaultValue="0") int num,
//			@ModelAttribute("vo") MemberVO vo) {	// jsp에서의 출력형태 : ${vo}
			MemberVO vo								// jsp에서의 출력형태 : ${memberVO}
			) {
		
		// 1.
		String id = req.getParameter("id");
		System.out.println("id : "+id);
		
		// 2.
		/* 
		 * - 기본값 : 필수입력    &&    매개변수명이 파라미터명과 일치해야함
		 * - 이름이 다른 경우 : @RequestParam의 name 속성에 파라미터명을 지정
		 * - 필수값이 아닌경우 : required 속성을 false로 지정
		 * - 기본자료형인 경우 : required=false로 지정해도 에러남 (null 지정할수없기때문)
		 *         -> defaultValue 지정
		 */
		System.out.println("name: " + name2);
		System.out.println("num: " + num);
		
		// 3. 커맨드 객체
		/*
		 * - VO(DTO) 객체에 필드명과 파라미터명이 일치하면 자동으로 저장해줌 (일치하지않으면 저장X)
		 * - 자동으로 request에 저장 (매개변수로 넣어주기만 하면 된다)
		 * - 배열로 전송되는 경우 각 값들을 ","로 구분하여 하나의 문자열로 저장함
		 * - (필드가 배열로 선언되었을시 배열로 전환해줌)
		 * 
		 */
		System.out.println("MemberVO: " + vo);
		
	}
	// 4. @PathVariable
	@GetMapping("/board/{page}/{searchWord}")
	public void path(@PathVariable int page, @PathVariable String searchWord) {
		// http://localhost:8080/spring/param/board/1/자바
		// -> page : 1, searchWord : 자바
		System.out.println("page : " + page);
		System.out.println("searchWord + " + searchWord);
		
	}
	
}
