package chapter05;

public class Exercise1 {

	public static void main(String[] args) {
		// 1부터 100까지의 정수 중 5의 배수의 합계를 출력하는 프로그램
		int sum = 0;
		
		// for문을 이용하여 반복 합계 연산
		// 첫번째 방법
//		int n = 100 / 5;
//		
//		for (int i=1; i<= n ; i++) {
//			sum += 5*i;
//		}
		
		// 두번째 방법
//		for (int i=1; i<=100; i++) {
//			if (i%5==0) {
//				sum += i;
//			}
//		}
		
		// 세번째 방법
		for (int i=0; i<=100; i+=5) {
			sum += i;
		}
		
		System.out.println("5의 배수의 합계는 " + sum);
		
	}

}
