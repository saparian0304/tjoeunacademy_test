package chapter08.poly;

public class Child extends Parent {
	
	String name;
	
	// 재정의메서드
	void run() {
		System.out.println("자식이 달린다.");
	}
	
	// 추가된 메서드
	void eat() {
		System.out.println("자식이 먹는다.");
	}
	
	public String toString() {return name;}
}

class Child2 extends Parent {
	
	void run() {  }
	
	void eat() {
		System.out.println("김치를 먹는다.");
	}
}
class Child3 extends Parent {
	
	void run() {  }
	
	void eat() {
		System.out.println("짜장을 먹는다.");
	}
}
class Child4 extends Parent {
	
	void run() {  }
	
	void eat() {
		System.out.println("치킨을 먹는다.");
	}
}