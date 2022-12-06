package com.example.sns.member;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.yaml.snakeyaml.constructor.DuplicateKeyException;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/member")
@AllArgsConstructor
public class MemberController {
	private MemberMapper mmapper;
	
//	MemberController(MemberMapper mmapper) {
//		this.mmapper = mmapper;
//	}
	
	@PutMapping("/regist")
	public Map regist(@RequestBody MemberVO vo) {
		var map = new HashMap<String, String>();
		String result = "";
		try {
			int r = mmapper.insert(vo);
			if (r > 0) result = "success"; 
			else result = "fail";
		} catch (DuplicateKeyException e) {
			//e.printStackTrace();
			result = "duplicate";
		} catch (Exception e) {
			result = "error";
		}
		map.put("result",result);
		return map;
	}
	
	@PutMapping("/update")
	public Map update(@RequestBody MemberVO vo) {
		var map = new HashMap<String, String>();
		String result = "";
		
		int r = mmapper.update(vo);
		if (r > 0) result = "success"; 
		else result = "fail";
		
		map.put("result",result);
		return map;
	}
	
	@PostMapping("/login")
	public Map login(@RequestParam Map param) {
		var map = new HashMap<String, Object>();
		String result = "";
		
		MemberVO r = mmapper.login(param);
		if (r != null) {
			result = "success";
			map.put("member", r);
		}
		else result = "fail";
		
		map.put("result",result);
		return map;
	}
	
	@GetMapping("/get")
	public Map get(@RequestParam int no) {
		var map = new HashMap<String, Object>();
		String result = "";
		
		MemberVO r = mmapper.getMember(no);
		if (r != null) {
			result = "success";
			map.put("member", r);
		}
		else result = "fail";
		
		map.put("result",result);
		return map;
	}
}
