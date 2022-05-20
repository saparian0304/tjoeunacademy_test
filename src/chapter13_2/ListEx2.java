package chapter13_2;

import java.util.ArrayList;
import java.util.List;

public class ListEx2 {

	public static void main(String[] args) {
		
		Member m = new Member();
		m.name = "홍길동";
		m.age = 30;
		
		List<Member> list = new ArrayList<Member>();
		list.add(m);
		m.name = "김길동";
		list.add(m);
		m.name = "최길동";
		list.add(m);
		
//		list.get(1).name = "박길동";
		// list 내 모든 요소가 참조변수 m을 가리키고 있기 때문에 모두 동일한 값이 출력됨
		for (int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).name);
		}

		
		// 해결방안 : 담을 때마다 객체를 새로 생성해야함
		Member m2 = new Member();
		m2.name = "홍길동";
		m2.age = 30;
		
		List<Member> list2 = new ArrayList<Member>();
		list2.add(m2);

		m2 = new Member();
		m2.name = "김길동";
		list2.add(m2);
		
		m2 = new Member();
		m2.name = "최길동";
		list2.add(m2);
		
		for (int i=0; i<list2.size(); i++) {
			System.out.println(list2.get(i).name);
		}
		
	}
}
