import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		// 10보다 작으면 0을 붙여서 두자리로 만든다 26
		// 각 자리의 숫자를 더한다 // 8 14 12 6
		// 맨 오른쪽 자리 둘을 붙인다 -> 새로운 수 // 68 84 42 26

		// 입력을 받는다
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		final int NUM = num;
		int cnt = 0;
		// 입력받은 수를 두자리로 만든다 (1회성)
		if (num < 10) num *= 10;
		int tenDigit = num/10;
		int oneDigit = num%10;
		
		int tmp = (tenDigit + oneDigit) % 10;
		if (NUM < 10) {
			num = NUM * 10 + tmp;
		} else {
			num = oneDigit * 10 + tmp;
		}
		cnt++;
		if (NUM == num) {
			System.out.println(cnt);
			return;
		}
		
		while (true) {
			tenDigit = num/10;
			oneDigit = num%10;
			
			tmp = (tenDigit + oneDigit) % 10;
			num = oneDigit * 10 + tmp;
			cnt++;
			if (NUM == num) {
				System.out.println(cnt);
				break;
			}
		}
		
		// 반복
		// 각 자리를 더한다			
		// 새로운 수를 만든다 (오른쪽 두 자리 합치기)
		// 입력값과 동일하면 중단
	}
}
