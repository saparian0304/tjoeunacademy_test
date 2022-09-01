package chapter12;

import chapter12.string.StringEx7;

public class WrapperEx {

	public static void main(String[] args) {

		int a = 10;		// 기본자료형
		Integer a2 = a;	// auto-boxing (기본자료형을 참조자료형으로 포장함)
		System.out.println(a2);
		int a3 = a2;	// unboxing	(다시 기본자료형으로 변환)
		
		
		test("홍길동");
		test(new StringEx7());
		test(1);		// 오토박싱 : int -> Integer
		test(1.45);		// 오토박싱 : double -> Double
	}
	
	public static void test(Object name) {
		System.out.println(name);
	}
}
