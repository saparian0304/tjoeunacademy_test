package chapter04;

public class OpEx5_2 {

	public static void main(String[] args) {
		
		int a = 10;
		int b = 5;
		
		// & 연산 -> 좌측항 연산결과에 상관없이 우측항 연산도 항상 수행됨 
		System.out.println("& 연산자 실행");
		System.out.println(a == b & test());
		
		// && 연산 -> 좌측항 연산결과에 따라 우측항 연산여부가 결정됨 (shortcut) 
		// 실행속도를 높일 수 있음
		System.out.println("&& 연산자 실행");
		System.out.println(a == b && test());	// 왼쪽항이 false이기때문에 test()메서드 실행되지 않음
		
	}

	public static boolean test() {
		System.out.println("test()메서드 실행됨");
		return true;
	}
}
