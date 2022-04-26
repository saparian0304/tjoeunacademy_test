package chapter03;

public class ScopeEx {

	int no;				// instance변수
	static int no1;		// class 변수
	public static void main(String[] args) {
		String name;
//		no = 10; 	class메서드이기 때문에 instance 변수를 사용하지 못함
		no1 = 1;	// class 메서드에서 class변수 사용이 가능함
	}

	void test2() {
		int age = 30;
		if(true) {
			no = 10;
			age = 40;
		}
	}
	
	void test() {
		no = 10;	// 클래스에 정의된 변수 (intance 변수)
//		age = 40;	// test2 메서드에 정의된 변수(test2의 지역변수)
	}
}
