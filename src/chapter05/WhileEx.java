package chapter05;

public class WhileEx {

	public static void main(String[] args) {
		int i = 1;
		int sum = 0;
		// while문
		while (i <= 100) {
			sum += i;
			System.out.println(i);
			i++;
		}
		
		System.out.println("합계 : " + sum);
		System.out.println("반복이 끝난 후 i = " + i);
		
		// do~while문
		// 최소한 한번은 실행하게하는 while문이라고 생각하자.
		i = 0;
		sum = 0;
		do {
			sum += i;
			System.out.println(i);
			i++;
		} while (i<=100);			// 마지막에 ';'이 들어간다는 점이 다르다.
	
		System.out.println("합계 : " + sum);
		System.out.println("반복이 끝난 후 i = " + i);
	}

}
