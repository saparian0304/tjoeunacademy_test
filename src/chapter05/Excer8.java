package chapter05;

public class Excer8 {

	public static void main(String[] args) {
/*
    *
   ***
  *****
 *******
*********

for문 두개만 사용해서 출력하기

공백 별 줄   공백+별
 4   1   1      5
 3   3   2      6
 2   5   3      7
 1   7   4      8
 0   9   5      9

*/
		
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=4+i; j++) {
				if (j <= 5-i)
					System.out.print(" ");
				else System.out.print("*");
			}
			
			System.out.println();
		}
	}

}
