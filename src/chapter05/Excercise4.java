package chapter05;

public class Excercise4 {

	public static void main(String[] args) {
		/*
		// 별 출력하기
		 *
		 ** 
		 ***
		 ****
		 *****
		 
		 */

		for (int i=1; i<=5; i++) {
			for (int j=1; j<=i; j++) {
				System.out.printf("*");
			}
			System.out.println();
				
		}
		
	}

}