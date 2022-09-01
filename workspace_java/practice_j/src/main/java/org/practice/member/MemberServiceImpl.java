package org.practice.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	MemberDAO dao;
	
	@Override
	public Map<String, Object> getList(MemberVO vo) {
		List<MemberVO> list = dao.list(vo);
		
		Map<String, Object> map = new HashMap();
		map.put("list", list);
		
		return map;
	}
}
