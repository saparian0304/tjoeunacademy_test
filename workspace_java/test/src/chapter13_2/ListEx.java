package chapter13_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListEx {

	public static void main(String[] args) {
		
		Member m = new Member();
		m.name = "홍길동";
		m.age = 30;
		
		// List 인터페이스 타입으로 ArrayList 객체를 생성
		List list = new ArrayList();
		list.add(m);
		list.add(1);
		list.add("안녕");
		
		
		System.out.println("요소의 개수는 : " + list.size());
		System.out.println(list.get(2));
		System.out.println(((Member)list.get(0)).name);	// 꺼내서 멤버변수를 사용하기 위해선 Member 타입으로 형변환 해야함
		
		System.out.println("=====일반 List for문=====");
		// for문으로 Member의 변수를 출력하려면 if문을 사용해야함 (instanceof연산자 이용)
		for (int i=0; i<list.size(); i++) {
			if (list.get(i) instanceof Member) {
			System.out.println(((Member)list.get(i)).name);
			}
		}
		
		// 제네릭 사용하기 -> 입력되는 객체의 타입을 강제할 수 있음0
		System.out.println("=======List 제네릭========");
		List<Member> list2 = new ArrayList<Member>();
		list2.add(m);		// add(Member e) 메서드의 매개변수타입이 Member로 변경되어있음
//		list2.add(1);		// Member 타입이 아니기때문에 에러가 남
//		list2.add("안녕");
		list2.add(m);		
		System.out.println(list2.get(0).name);		// 형변환 없이 출력이 가능함
		
		// 일반 Map
		System.out.println("=========일반 Map=========");
		Map map = new HashMap();
		map.put("name", "김길동");
		map.put("age", 30);
		map.put("member", m);
		// Member 객체의 name 출력
		System.out.println(((Member)map.get("member")).name);
		
		// Map 제네릭 사용하기
		System.out.println("=========Map 제네릭=======");
		Map<String, Member> map2 = new HashMap<String, Member>();
		map2.put("m1", m);
		map2.put("m2", m);
		map2.put("m3", m);
		System.out.println(map2.get("m1").name);
		
		
		
		
		
	}

}
