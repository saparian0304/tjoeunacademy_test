package chapter05;

public class Excercise6 {

	public static void main(String[] args) {
		/*
		 별 출력하기
		     *
		    ***
		   *****
		  *******
		 *********
		 
		 */
		
		// 공백 4번, 별 1개
		// 공백 3번, 별 3개
		// 공백 2번, 별 5개
		// 공백 1번, 별 7개
		// 공백 0번, 별 9개
		
		// 첫번째 방법
//		for (int i=1; i<=5; i++) {
//			for (int j=4; j>=i; j--) {
//				System.out.print(" ");
//			}
//			
//			for (int j=1; j<=2*i-1; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		// 공백 4번, 별 1개
		// 공백 3번, 별 3개
		// 공백 2번, 별 5개
		// 공백 1번, 별 7개
		// 공백 0번, 별 9개

		// 두번째 방법
		for (int i=1; i<=5; i++) {
			for (int j=5; j>1; j--) {
				if (j > i) 
					System.out.print(" ");
				else System.out.print("**");
			}
			System.out.println("*");
		}
	}
}
