package chapter03;

public class Var {
	public static void main(String[] args) {
		int a;	// 변수 선언
		a = 10;	// 변수 초기화 (변수 a에다가 10을 저장)
		System.out.println(a);
		int b = 20;
		System.out.println(b);
		
		int age = 30;	// 변수의 이름을 지을때 의미를 부여하자.
		int 나이 = 10; 	// 변수 이름을 한글로 쓸 수도 있지만 사용하지 말자.
		
		long c = 21000000000L;	// 21억이 넘을 경우 long 사용
		byte d = 100;	// 1 byte
		byte e = 10;
//		byte f = d+e;	연산이 일어나는 순간 int로 변환!
		
		float f = 3.14f;
//		float f2 = 3.14; 소수점이 있는 수(실수) 기본이 double!
		double g = 3.14;	// 숫자 뒤에 d 안써도 됨
		
		boolean h = false;	// true, false 둘 중 하나
		
		char i = 'A';	// 정수 65
		char i2 = 'B';	// 정수 66
		System.out.println(i+i2);	// 65 + 66 = 131
		
		// 문자열 ABC....
		// 큰따옴표로 감싸면 -> 문자열
		String name = "홍길동";
		System.out.println(name);
		System.out.println(name);
		System.out.println(name);

		// 참조자료형은 null로 초기화 가능
		String name2 = null;	// null은 값 자체가 존재하지 않는 상태!
		String name3 = ""; 		// 빈 문자열임 (null과는 다름)
		String name4 = " "; 	// 공백 문자열 (빈 문자열, null과 다름)
		String name5 = "A"; 	// 문자(char) 아님, 큰따옴표는 문자열!
		
		// 상수는 대문자로 사용!, 초기화 한 후 값을 변경할 수 없음 
		final String AA = "1";
		//AA = "2";
		final String BB;
		BB = "2";
		
		System.out.print(name);
		System.out.print(name);
		System.out.print(name);
		String greet = "안녕하세요\n\t반갑습니다";	// "\n"은 줄바꿈 문자 (개행문자)
		System.out.println(greet);
		System.out.println("안녕하세요 저는 \"홍길동\"입니다.");
	}
}
