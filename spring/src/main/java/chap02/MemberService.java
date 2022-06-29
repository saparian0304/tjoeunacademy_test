package chap02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
public class MemberService {

//	@Autowired		// 타입을 보고 주입을 해줌
//	@Qualifier("memberDAO2")	// 해당 이름의 Bean에 주입을 해줌
	MemberDAO dao;
	
	public void insert() {
		dao.insert();
	}
}
