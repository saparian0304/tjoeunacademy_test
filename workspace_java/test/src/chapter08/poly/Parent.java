package chapter08.poly;

// 추상클래스
public abstract class Parent {

	String name;
	
	void walk() {
		System.out.println("부모가 걷는다.");
	}
	
	void run() {
		System.out.println("부모가 달린다.");
	}
	
	// 추상메서드 (자식 클래스에서 반드시 재정의)
	abstract void eat();
}
