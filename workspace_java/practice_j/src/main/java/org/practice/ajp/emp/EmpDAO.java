package org.practice.ajp.emp;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmpDAO {

	@Autowired
	SqlSessionTemplate sst;
	
	public List<EmpVO> selectList(EmpVO vo) {
		List<EmpVO> list= sst.selectList("emp.selectList", vo);
		
		return list;
	}
	
}
