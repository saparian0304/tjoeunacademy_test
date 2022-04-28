package cloud;

public class Bills {

	public static void main(String[] args) {
		/* 1. 변수 생성 */
	    int ilman = 3;
	    int ochun = 4;
	    int ilchun = 7;
	    int sum = 0;
		/* 2. 계산 */
		sum += ilman * 10000;
		sum += ochun * 5000;
		sum += ilchun * 1000;
	    /* 3. 출력 */
		System.out.println(sum + "원");
	}

}
