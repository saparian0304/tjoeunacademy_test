package org.practice.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class MemberServiceImpl {
	
	@Autowired
	MemberDAO dao;
	
	public Map<String, Object> getList(MemberVO vo) {
		List<MemberVO> list = dao.list(vo);
		
		Map<String, Object> map = new HashMap();
		map.put("list", list);
		
		return map;
	}
}
