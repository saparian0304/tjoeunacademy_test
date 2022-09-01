package chap06;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController			// REST API 개발을 위한 어노테이션 (빈으로 등록이 됨)
@RequestMapping("/api")	// 시작경로
//@CrossOrigin(origins = {"http://192.168.0.19:5500"})	// CORS(접근허용)
@CrossOrigin(origins = {"*"})	// CORS(접근허용) - 모든곳에서 접근 가능
public class ApiController {
	
	@Autowired
	BoardMapper mapper;
	
	@GetMapping(value="/hello", produces = "text/plain; charset=UTF-8")
	public String hello() {
		return "hello";
	}
	
	// get
	@GetMapping("/get1")	// 1. @RequestParam
	public String get1(@RequestParam String id) {
//	public String get1(@RequestParam(required=false) String id) {
		return id;
	}
	
	@GetMapping("/get2/{id}")	// 2. @PathVariable
	public String get2(@PathVariable String id) {
		return id;
	}
	
	@GetMapping("/get3")		// 3. HttpServletRequest 객체
	public String get3(HttpServletRequest req) {
		return req.getParameter("id");
	}
	@GetMapping(value="/get4")	// 4. 커맨드객체
	public MemberVO get4(MemberVO vo) {
		return vo;
	}
	
	// post
	@PostMapping("/post1")	// 요청시 json으로 데이터 전송
	public void post1(@RequestBody Map<String, Object> map) {
		Iterator iter = map.keySet().iterator();
		
		while(iter.hasNext()) {
			String key = (String)iter.next();
			Object value = map.get(key);
			System.out.println(key + " : " + value);
		}
	}
	
	@PostMapping("/post2")
	public void post2(@RequestBody MemberVO vo) {
		System.out.println(vo);
	}
	
	// put ( == post)
	@PutMapping("/put1")
	public void put1(@RequestBody MemberVO vo) {
		System.out.println(vo);
	}
	@PutMapping("/put2")
	public MemberVO put2(@RequestBody MemberVO vo) {
		return vo;
	}
	/*
	 요청 및 응답에서 문제가 생기는 경우
	 - 표기법이 다른 경우 (카멜, 스네이크)  // 예 : 카멜로 요청하면 스네이크에서는 담기지 않음
	  1. 클래스내 모든 필드 전체 적용 (@JsonNaming 어노테이션 사용)
	    VO클래스에 @JsonNaming 어노테이션 사용해서 해결 가능
	    예 : @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
	    요청(스네이크) -> 처리(카멜, VO) -> 응답(스네이크)
	  
	  2. 필드별로 개별 적용 (@JsonProperty 어노테이션 사용)
	    예 : @JsonProperty("nick_name")
	    
	 - 값이 없는 경우(null)
	  1. VO클래스에 @JsonInclude 어노테이션 사용
	     VO객체에 담을 데이터를 정할 수 있음
	     예 : @JsonInclude(value = Include.NON_NULL) -> null값이 아닌 데이터만 vo객체에 담아서 전송함
	 */
	
	// delete (get, post 유사)
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable String id, 
						HttpServletRequest req, 
						@RequestParam String num,
						MemberVO vo2) {
		System.out.println("id: " + id);
		System.out.println("req.id: " + req.getParameter("id"));
		System.out.println("num: " + num);
		System.out.println("vo2.id: " + vo2.getId());
	}
	
	@RequestMapping("/board/list")
	public List<BoardVO> boardList(Criteria cri) {
		return mapper.getListWithPaging(cri);
	}
}
