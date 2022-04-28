package cloud;

public class Income {

	public static void main(String[] args) {
		/* 1. 변수 생성 */
	    double mon, tue, wed, thu, fri, sum;
	    mon = 8.62;
	    tue = 10.23;
	    wed = 12.48;
	    thu = 7.82;
	    fri = 9.54;
	    /* 2. 총합 계산 */
	    sum = mon + tue + wed + thu + fri;
	    
	    /* 3. 총합 출력 */
	    System.out.printf("$ %.2f", sum);
	}

}
