package chapter08.poly;

import java.util.Scanner;

public class PolyEx {

	public static void main(String[] args) {
		
		Child c = new Child();
		c.name = "이순신";
		c.run();
		
		// 부모클래스의 자료형으로 선언 (자동형변환)
		Parent p = new Child();
		p.run();	// 부모타입으로 변해도 재정의된 메서드가 실행
//		p.eat();	// 에러
		
		Parent[] childs = {c, new Child2(), new Child3(), new Child4()};
		for (int i=0; i<childs.length; i++) {
			childs[i].eat();
			restaurant(childs[i]);
		}
		home(childs[0]);
		home("홍길동");
		home(new Scanner(System.in));
	}
	
	// 부모클래스를 매개변수로 사용하면 모든 자식클래스를 사용할 수 있음
	public static void restaurant(Parent p) {
		p.eat();
	}
	
	public static void home(Object obj) {
		// Object를 매개변수로 한 경우 모든 자료형이 올 수 있음
		System.out.println(obj);
	}
}
