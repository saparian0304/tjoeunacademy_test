package chapter05;

public class Excer1 {

	public static void main(String[] args) {
		// 1~100까지의 정수 중 5의 배수의 합계를 출력해라
		int sum = 0;
		
		for (int i=1; i<=100; i++) {
			if (i%5==0) sum += i;
		}
		
		// for문을 이용하여 반복 합계 연산
		
		System.out.println("5의 배수의 합계는 " + sum);

		// 다른 방식
		sum = 0;
		for (int i=5; i<=100; i+=5) {
			sum += i;
		}		
		System.out.println("5의 배수의 합계는 " + sum);
		
	}

}
