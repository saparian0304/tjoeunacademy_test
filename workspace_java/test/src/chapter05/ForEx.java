package chapter05;

// 반복문 - for문
public class ForEx {

	public static void main(String[] args) {
		
		for(int i=0; i<10; i++) {
			System.out.println("i = " + i);
		}
		
		// 반복문을 사용할 때
		// 1. 반복
		// "철수야 안녕?"을 100번 출력
		// 2. 패턴이 존재함 (패턴을 찾아내야함)
		// 1부터 100까지 더해라
		System.out.println("철수야 안녕?");
		int sum = 0;
		
		for (int x=1; x<=10000; x++ ) {
			sum = sum + x;
		}
		System.out.println(sum);
	}

}
