package chapter05;

public class Excer6 {

	public static void main(String[] args) {
		// 이중 for문 사용해서 똑같이 출력하기

/*
    *
   ***
  *****
 *******
********* 
 
줄 공백 별
1   4   1
2   3   3
3   2   5
4   1   7
5   0   9
 
 */
		// 내가 푼 방법
		for(int i=0; i<5; i++) {
			for(int j=3; j>=i; j--) {
				System.out.print(" ");
			}
			
			for(int k=1; k<=2*i+1; k++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
		
		
		// 풀이방법
		for(int i=1; i<=5; i++) {				// 줄 반복
			for(int j=5-i; j>0; j--) {			// 공백 반복 출력
				System.out.print(" ");
			}
			for(int k=1; k <= 2*i-1; k++) {		// 별 반복 출력
				System.out.print("*");
			}
			System.out.println();
		}
	}

}


