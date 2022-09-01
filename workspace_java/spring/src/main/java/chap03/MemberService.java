package chap03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Component
@Service	// @Component와 동일하나 MVC에서 용도에 따라 의미를 부여함 (Service -> Service)
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class MemberService {

	@Autowired		// 타입을 보고 주입을 해줌
	MemberDAO dao;
	
	public void insert() {
		dao.insert();
	}
}
