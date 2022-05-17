package chapter07;

public class MethodEx2 {

	public static void main(String[] args) {
		
		System.out.println(divide(pow(add(3,3))));
		
		// 위와 같은 실행 순서
		int a = add(3,3);
		int p = pow(a);
		int d = divide(p);
		System.out.println(d);
		
		
		// pow2(값, 계승)
		System.out.println(pow2(3,-2));
		
		// 오버로딩
		System.out.println(1);					// 매개변수 : 정수형
		System.out.println(1.5);				// 매개변수 : 실수형
		System.out.println("");					// 매개변수 : 문자열
		System.out.println(new MethodEx2());	// 매개변수 : 객체
	}

	static int pow2(int x, int y) {
		int result = 1;
		for (int i=0; i<y; i++) 
			result *= x;
		return result;
	}
	
	static int add(int x, int y) {
		return x + y;
	}
	
	static int pow(int x) {
		return x * x;
	}
	
	// 메서드 오버로딩 -> 동일한 이름의 메서드가 여러개 정의되어있음 
	// 매개변수의 자료형, 개수, 순서 중 하나 이상 달라야함
	static int pow(String x) {
		return 0;
	}
	
	static int divide(int x) {
		return x / 2;
	}
}
