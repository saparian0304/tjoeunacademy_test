package chapter05;

public class Gugudan {
	public static void main(String[] args) {
		// 2단		
//		System.out.println("2 * 1 = 2");
//		System.out.println("2 * 2 = 4");
//		System.out.println("2 * 3 = 6");
//		//                     ...
//		System.out.println("2 * 9 = 18");

		
		
//		// 반복문 - 1단계
//		for (int i=1; i<=9; i++) {
//			System.out.println("2 * " + i + "= " + 2*i);	
//		}
//		for (int i=1; i<=9; i++) {
//			System.out.println("3 * " + i + "= " + 3*i);	
//		}
		
		
		// 반복문 -> 중첩
		
		for (int j=2; j<=9; j++) {			// 단 반복
			System.out.println("[" + j + "단]");
			for (int i=1; i<=9; i++) {		// 곱수 반복
				System.out.println(j + " * " + i + " = " + j*i);	
			}		
		}
	}
}
