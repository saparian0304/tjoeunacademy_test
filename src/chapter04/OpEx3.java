package chapter04;

public class OpEx3 {

	public static void main(String[] args) {
		
//		int a = 10;
//		int b = 10;
//		
//		++a;	// 전위연산
//		b++;	// 후위연산
//		
//		System.out.println(a);
//		System.out.println(b);

	
		int a = 10;
		// int b = ++a;	
		int b = a++;	// a를 b에 대입한 후 a에 1을 더한다.
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		
		// 전위(앞), 후위(뒤) 구분기준이 실행문(;)
		// 전위연산은 실행문이 실행되기 전
		// 후위연산은 실행문이 실행된 후 
		
		System.out.println(10 > 20);
		System.out.println(10 < 20);
		System.out.println(10 == 20);
		System.out.println(10 != 20);
		
		System.out.println('A' < 'B');
		System.out.println();
//		System.out.println("A" < "A");	// 문자열은 크기 비교 불가
		System.out.println("A" != "A");
		System.out.println();
		
		boolean c = 10<20;	// true
		System.out.println(c);
		
		boolean d = 10 == 20;	// false
		System.out.println(d);
	}

}
