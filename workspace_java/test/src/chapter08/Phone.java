package chapter08;

public class Phone {
	
	String name;
	String color;
	String company;
	
	void call() {
		System.out.println("전화를 건다");
	}
	
	void receive() {
		System.out.println("전화를 받다");
	}

	@Override	// 오버라이딩하는 메서드임을 표시해줌
	public String toString() {
		return "Phone";
	}
}
