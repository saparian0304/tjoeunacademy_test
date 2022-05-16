package chapter06;

public class Lotto {

	public static void main(String[] args) {
		
		// 로또번호 6개를 담을 변수
		int[] lotto = new int[6];
		
		// 다음 로또번호를 저장할 위치(인덱스)
		int idx = 0;
		// 반복횟수를 알수가 없으므로 while문 사용
		while (true) {
			// 로또번호(랜덤) 뽑기
			int number = (int)(Math.random() * 45) +1;
			
			// 등록여부
			boolean insert = true;
			// 중복체크
			for (int i=0; i< idx; i++) {
				// 해당인덱스의 값과 랜덤값이 같은지 (중복인지)
				if (lotto[i] == number) {
					insert = false;	// 등록여부를 불가로 변경
					break;	// 반복중지
				}
			}
			
			// 중복이 없으면 insert = true
			if (insert) lotto[idx++] = number;	// 해당 위치에 랜덤값을 대입 후 idx 1 증가
			
			// 6개 로또번호를 다 뽑았으면 반복 중지
			if (idx == 6) break;
		}
		
		for (int i=0; i<lotto.length; i++) {
			System.out.println(lotto[i]);
		}
		
		
		
		/* 	내가 한 방법
		int[] lotto = new int[6];
		
		// 랜덤으로 숫자를 뽑는다
		// 숫자를 확인한다
		// 확인 후 배열에 없으면 넣는다
		// 6번째까지 채우면 종료한다.
		int num;
		while(true) {
			
			num = (int)(Math.random() * 45) + 1;
			
			boolean flag = true;
			for (int i=0; i<lotto.length; i++) {
				if (num == lotto[i]) {
					flag = false;
				}
			}
			if (flag == false) {
				continue;
			}
			if (lotto[lotto.length-1]!=0) {
				break;
			} else {
				for (int i=0; i<lotto.length; i++) {
					if (lotto[i] == 0) {
						lotto[i] = num;
						break;
					}
				}
			}
			
			
		}
		for (int i=0; i<lotto.length; i++) {
			System.out.println(lotto[i]);
		}
		*/
	}

}
