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
		
		// 1줄, 공백 4번, 별 1개
		// 2줄, 공백 3번, 별 3개
		// 3줄, 공백 2번, 별 5개
		// 4줄, 공백 1번, 별 7개
		// 5줄, 공백 0번, 별 9개
		
		// 첫번째 방법
		for (int i=1; i<=5; i++) {
			for (int j=4; j>=i; j--) {
				System.out.print(" ");
			}
			
			for (int j=1; j<=2*i-1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println();
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
		
		/*
		 for문 2개만 사용
		 1줄 : 5
		 2줄 : 4,5,6
		 3줄 : 3,4,5,6,7
		 4줄 : 2,3,4,5,6,7,8
		 5줄 : 1,2,3,4,5,6,7,8,9
		 */
		int line = 5;
		for (int i=1, j=2*line-1; i<=line; i++) {
			
			for (int k=1; k<=j;k++) {
				// 공백
				if (k <= line-i || k>line+i-1) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println();
		System.out.println();
		// 위 방법으로 다시 풀어보기
		for (int i=1; i<=5; i++) {
			// 총 9번 반복
			for(int j=1; j<=9; j++) {
				if (j <= 5-i || j >= 5+i) {
					System.out.print(" ");
				} else 
					System.out.print("*");
			}
			System.out.println();
		}
		
	}
}

















