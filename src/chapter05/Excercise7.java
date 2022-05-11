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
