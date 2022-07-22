package kr.co.project.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberMapper mapper;
	
	@Override
	public int insert(MemberVO vo) {
		return mapper.insert(vo);
	}

	@Override
	public boolean checkEmail(MemberVO vo) {
		
		return mapper.checkEmail(vo) > 0;
	}

}
