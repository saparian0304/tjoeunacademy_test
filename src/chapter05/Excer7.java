package chapter05;

public class Excer7 {

	public static void main(String[] args) {
		// 주사위 눈이 6이 나올때까지 반복해서 둘리고, 6이 나오면 주사위 굴린 횟수 출력하기
		
		int count = 0;
		boolean flag = true;
		while (flag) {
			int dice = (int)(Math.random()*6) +1;
			System.out.println("(" + dice + ")");
			if (dice == 6) flag = false;
			count++;
		}
		System.out.println("총 주사위 굴린 횟수는 : " + count + "회");
	}

}
