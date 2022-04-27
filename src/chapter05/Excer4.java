package chapter05;

public class Excer4 {

	public static void main(String[] args) {
		// 이중 for문 사용해서 똑같이 출력하기
		/*
		 * 
		 **
		 ***
		 **** 
		 *****
		 
		  줄 (1~5)
		  별 개수가 (1~5)
		  
		  
		 */
		for (int i=0; i<5; i++) {			// 줄 반복
			for (int j=0; j<=i; j++) {		// 별 반복 (줄 번호만큼)
				System.out.print("*");
			}
			System.out.println();
		}

	}

}
