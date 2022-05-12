package chapter05;

public class Excercise7 {

	public static void main(String[] args) {
		// 주사위가 6이 나올때까지 반복
		// 나온 횟수 출력
		int dice;
		int cnt = 0;
		boolean flag = true;
		
		while (flag) {
			dice = (int)(Math.random()*6)+1;
			cnt++;
			System.out.println("(" + dice + ")");
			if (dice == 6) 
				flag = false;
		}
		System.out.println("총 주사위를 굴린 횟수는 : " + cnt + "회");
	}

}
/*
 while
 	주사위 굴리기
 	굴린횟수 +1
 	만약 주사위가 6이 나오면 중지
 굴린 횟수 출력
 
 랜덤값
 Math.random() -> 0~1미만의 실수 리턴
 이 랜덤실수 값에 6을 곱하면 0 부터 5.99999~까지    -> 곱하는 수 : 랜덤값의 범위
 이 값을 정수로 형변환 -> 0~5
 이 값에 시작하고 하는 값을 더하면 (+1) -> 1~6		-> 더하는 수 : 랜덤값의 시작값
 (int)(Math.random() * 6)+1
*/
