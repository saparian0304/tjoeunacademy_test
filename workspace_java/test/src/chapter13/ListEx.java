package chapter13;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class ListEx {

	public static void main(String[] args) {

		List list = new ArrayList();
//		List list = new Vector();	// List를 구현한 다른 클래스로 변환하게 되더라도 아래 코드들을 수정할 필요가 없음
		
		list.add(1);
		list.add(2.5);
		list.add(true);
		list.add("홍길동");
		list.add(5);
		list.add(6);
		System.out.println(list);	// toString()이 재정의 되어있다.
		
//		for (int i=0; i<list.size(); i++) {
//			System.out.println("list["+i + "]:" + list.get(i));
//		}
		
		// 향상된 for문
		System.out.println("향상된 for문으로 list 요소 출력하기");
		for (Object e : list) {
			System.out.println(e);
		}
		
		System.out.println("Vector 사용");
		Vector vec = new Vector();
		vec.addElement(1);	// 컬렉션프레임워크가 만들어지기 전에 있던 메서드
		vec.addElement(2);	// add()와 동일한 기능을 가짐
		vec.addElement(3);
		vec.addElement(4);
		vec.addElement(5);
		vec.addElement(6);
		vec.add(7);
		
		for (int i=0; i<vec.size(); i++) {
			System.out.println("vec["+i + "]:" + vec.get(i));
		}
		
		System.out.println(vec);
		
		// Iterator를 사용해서 반복
		System.out.println("Iterator를 사용해서 반복");
		Iterator it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		
	}

}
