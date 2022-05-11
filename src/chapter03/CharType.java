package chapter03;

public class CharType {
	// 기본자료형 - 정수형 char
	public static void main(String[] args) {
		/*
		 문자 - 하나의 문자, ''로 감싸서 표현
		 문자열 - 문자들이 나열, ""로 감싸서 표현 (String) 
		 */
		char a = 'A';
		System.out.println("a:" + a);
		
		int b = a;
		System.out.println("b:" + b);
		
		char c = 66;
		System.out.println("c:" + c);
		
		int d = a + b;	// 65 + 65
		System.out.println("d:" + d);
		
	}

}
