package chapter03;

public class CastingEx {

	public static void main(String[] args) {
		// 자동 형변환 : 작은 자료형 -> 큰 자료형
		int number = 10;
		long number2 = number;
		System.out.println(number2);
		
		// 강제 형변환 : 큰 자료형 -> 작은 자료형
		double pi = 3.14;
		int pi2 = (int)pi;			// 강제 형변환
		System.out.println(pi2);	// 값의 손실 발생
	
		// 대입연산자 +=
		number += 10;		// number = number + 10; 와 같은 의미	
		System.out.println(number);
	
	}

}
