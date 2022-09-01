package chapter07;

import java.util.ArrayList;
import java.util.List;

// 싱글톤 기법에 사용되는 예제 클래스
public class MemberDAO {
	
	List selectList(int p) {
		
		return new ArrayList();
	}
	
	MemberVO select(int pk) {
		
		return new MemberVO();
	}
	
	void update() {
		
	}
	
	void delete() {
		
	}
}
