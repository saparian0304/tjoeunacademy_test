package chapter05;

public class Excercise5 {

	public static void main(String[] args) {
		/*
		
		 별 출력하기
		 *****
		 ****
		 ***
		 **
		 *
		 		 
		 1줄 별5
		 2줄 별4
		 3줄 별3
		 4줄 별2
		 5줄 별1
		 
		 */

		for (int i=5; i>=1; i--) {
			for (int j=1; j<=i; j++) {
				System.out.printf("*");
			}
			System.out.println();
		}

		System.out.println();
		
		for (int i=1; i<=5; i++) {
			for (int j=1; j<=6-i; j++) {
				System.out.printf("*");
			}
			System.out.println();
		}
		
		
	}

}
