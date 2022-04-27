package chapter05;

public class whileEx2 {

	public static void main(String[] args) {
		// 랜덤값
		System.out.println(Math.random());
		// 0 <= 랜덤값 < 1
		
		// 주사위 (1~6)
		// 랜덤값(n)*6
		// 0 <= n < 6
		// 정수로 형변환	(0~5)
		// +1
		// 1 <= n < 7 		(1~6)
//		int dice = (int)(Math.random()*6) + 1;
//		System.out.println(dice);
		
		// 무한반복문 - for문
		for ( ; ;) {
			int dice = (int)(Math.random()*6) +1;
			System.out.println(dice);
			if (dice == 6) break;		// break는 반복문을 중지함
		}

		//무한반복문 - while문
		boolean flag = true;
		while (flag) {
			int dice = (int)(Math.random()*6) +101;
			System.out.println(dice);
			if (dice == 106) flag = false;
		}
		
		// continue : 건너뜀 (현재 반복만 중지 -> 다음반복으로 건너뜀)
		System.out.println();
		System.out.println("continue = 건너뜀");
		
		for (int i=0; i<=10; i++) {
			if (i==5) continue;		// continue : 실행문을 더이상 진행하지 않고 다음 반복으로 넘어감!
			System.out.println(i);
		}
	}

}
