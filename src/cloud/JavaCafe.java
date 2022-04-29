package cloud;

public class JavaCafe {
	public static void main(String[] args) {

		printPay(10.00, 40);
		printPay(10.00, 50);
		printPay(7.50, 38);
		printPay(8.50, 66);

	}

	// 시급과 일한 시간을 입력받아, 주급을 출력
	public static void printPay(double basePay, int hours) {
		if (basePay < 8) {
			System.out.println("최저 시급 에러!");
			return;
		} 
		
		if (hours > 60) {
			System.out.println("초과 근무시간 에러!");
			return;
		}
		
		double pay = basePay * hours;
		if (hours > 40) {
			int overTime = hours - 40;
			pay = 40 * basePay + overTime * basePay * 1.5;
		}
		System.out.printf("$ %.2f\n", pay);
	}
//		double pay = 0.0;
//		if (basePay < 8.00) {
//			System.out.println("최저 시급 에러!");
//		}	else if (hours >= 60 ){
//			System.out.println("초과 근무시간 에러!");
//		}	else if (hours > 40) {
//			pay = 40 * basePay + (hours-40)* basePay * 1.5;
//			System.out.printf("$ %.2f\n", pay);
//		} else {
//			pay = hours * basePay;
//			System.out.printf("$ %.2f\n", pay);
//		}
}


