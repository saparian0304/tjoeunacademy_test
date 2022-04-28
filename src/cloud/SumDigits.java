package cloud;

public class SumDigits {

	public static void main(String[] args) {
		/* 1. 변수 생성 */
		int num = 374;
		int oneDigit, tenDigit, hundDigit;
		int sumDigit;
		/* 2. 계산 */
		oneDigit = num % 10;
		tenDigit = num / 10 % 10;
		hundDigit = num / 100;
		sumDigit = oneDigit + tenDigit + hundDigit;
		/* 3. 출력 */
		System.out.println("총합: " + sumDigit);
	}

}
