package org.practice.ajp.emp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	public EmpDAO dao;
	
	@Override
	public Map list(EmpVO vo) {
		List<EmpVO> list = dao.selectList(vo);
		Map map = new HashMap<String, Object>();
		
		map.put("empList", list);
		
		return map;
	}

}
