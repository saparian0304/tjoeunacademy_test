package chap03;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component
@Repository // @Component와 동일하나 MVC에서 용도에 따라 의미를 부여함 (DAO -> Repository)
public class MemberDAO {
	
	public void insert() {
		System.out.println("등록");
	}
}
