package chapter06;

public class ArrEx8 {

	public static void main(String[] args) {
		
		int[] number = new int[100];
		
		// 배열 변수에 값 대입
		for (int i=0; i<number.length; i++) {
			number[i] = i+1;
		}
		
		// 배열 변수 출력
		for (int i=0; i<number.length; i++) {
			System.out.println(number[i]);
		}
		
		// 향상된 for문
		for (int n : number) {
			System.out.println(n);
		}
	}

}
