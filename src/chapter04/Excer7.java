package chapter04;

public class Excer7 {

	public static void main(String[] args) {
		
		/*
		 * 십의자리 이하를 버리는 코드
		 * 예) 1234 -> 1200, 123 -> 100
		 */
		int number = 13102;
		int result = number / 100 * 100;
		System.out.println(result);
		
		int result2 = number - number % 100;
		System.out.println(result2);
		
	}

}
