package chap05;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/board")		// 해당 컨트롤러의 모든 매핑 URL 앞에 공통으로 적용됨
public class UrlMappingController {
	
	@RequestMapping("/test.do")		// 요청 URL
	public String test() {
		return "test";				// 응답(포워딩) - jsp 경로 (설정에서 prefix, suffix 제외한 경로)
	}
	
	// get방식으로 매핑
	@RequestMapping(value = "/get.do", method = RequestMethod.GET)
	public String get() {
		return "get";
	}
	
	@GetMapping("/get2.do")
	public String get2() {
		return "get";
	}
	
	// post 방식으로 매핑
	@RequestMapping(value = "/post.do", method = RequestMethod.POST)
	public String post() {
		return "post";
	}
	
	@PostMapping("/post2.do")
	public String post2() {
		return "post";
	}
	
	/*
	 * 그냥 @RequestMapping만 쓰는 경우
	 *  -> Get, Post, ... 전부 받을 수 있음
	 * 
	 */
	
	// 하나의 url에서 두개의 처리 (로직, 응답), 2개 이상도 가능
	// /board/write.do (쓰기 폼, 등록)        서블릿에 doGet(), doPost()처럼 사용이 X 

/*시작*******************
 ******불가능한 예*******
 ***********************/

//	@RequestMapping("/board/write.do")
//	public String boardWrite() {
//		return "board/write";
//	}
	
	// 매핑 URL이 중복되면 서버시작할 때 에러 발생
//	@RequestMapping("/board/write.do")
//	public String boardWrite2() {
//		return "board/insert";
//	}
	
/************************
 ******불가능한 예*******
 *********************끝*/	
	
	
	// 하나의 url에서 두개의 처리 (로직, 응답), 2개 이상도 가능
	// 1. Request 객체로 구분해서 처리하기
	// 2. @RequestMapping으로 구분
	// 3. @GetMapping / @PostMapping으로 구분
	
	// 1번째 방법 - Request 객체 구분
//	@RequestMapping("/board/write.do")
	public String write(HttpServletRequest req) {
		String viewName = "";
		if (req.getMethod().equals("GET")) {
			System.out.println("get");
			viewName = "board/write";
		} else {
			System.out.println("post");
			viewName = "board/insert";
		}
		return viewName;
	}
	
	// 2번째 방법 - @RequestMapping으로 구분
//	@RequestMapping(value="/board/write.do", method = RequestMethod.GET)
	public String write2() {
		System.out.println("get");
		return "board/write";
	}
//	@RequestMapping(value="/board/write.do", method = RequestMethod.POST)
	public String write3() {
		System.out.println("post");
		return "board/insert";
	}
	
	// 3번째 방법 @GetMapping / @PostMapping으로 구분
	@GetMapping("/board/write.do")
	public String write4() {
		System.out.println("get");
		return "board/write";
	}
	@PostMapping("/board/write.do")
	public String write5() {
		System.out.println("post");
		return "board/insert";
	}
}











