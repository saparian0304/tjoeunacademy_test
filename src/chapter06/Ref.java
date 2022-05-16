package chapter06;

public class Ref {

	public static void main(String[] args) {
		
		// 배열도 참조자료형
		
		// 기본자료형
		int a = 10;
		int b = a;		// b에 10(a의 값)을 대입
		b = 20;
		System.out.println("a : " + a);		// a의 값은 변하지 않음
		
		// 참조자료형
		int[] a2 = {1,2,3};
		int[] b2 = a2;	// b2에 a2의 주소값을 대입
		b2[0] = 4;	// {4,2,3}
		System.out.println("a2[0] : "+ a2[0]);	// a2의 값도 변함
	}

}
