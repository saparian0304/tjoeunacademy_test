package chapter05;

public class Gugu {
	// 구구단 ( 반복문의 중첩 )
	public static void main(String[] args) {
		
		for (int j=2; j<=9; j++) {
			System.out.println( "    "+ j + "단");
			for (int i=1; i<=9; i++) {
				System.out.println(j + " * " +i+ " = " + j*i);
			}
			System.out.println();
		}
		
	}
}
