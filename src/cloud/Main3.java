package cloud;

public class Main3 {

	public static void main(String[] args) {
		// 변수 생성
	    int price = 152365;
	    
	    /* 1. 장수 계산 */
	    int oman = price / 50000;
	    int man = price % 50000 / 10000;
	    int ochun = price % 10000 / 5000;
	    int chun = price % 5000 / 1000;
	    
	    /* 2. 할인 금액 계산 */
	    int discounted = price % 1000;
	    
	    /* 3. 총 지폐 수 계산 */
	    int totalCnt = oman + man + ochun + chun;
	    
	    // 결과 출력
	    System.out.printf("5만원 x %d\n", oman);
	    System.out.printf("1만원 x %d\n", man);
	    System.out.printf("5천원 x %d\n", ochun);
	    System.out.printf("1천원 x %d\n", chun);
	    System.out.println("--------------");
	    System.out.printf("총 장수: %d장\n", totalCnt);
	    System.out.printf("금액: %d원\n", price - discounted);
	    System.out.printf("할인: %d원\n", discounted);

	}

}
