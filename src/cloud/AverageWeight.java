package cloud;

public class AverageWeight {

	public static void main(String[] args) {
		/* 1. 변수 생성 */
//	    double wei_1mon = 81.36;
//	    double cha_2mon = 0.71;
//	    double cha_3mon = -0.43;
//	    double wei_2mon = wei_1mon + cha_2mon;
//	    double wei_3mon = wei_2mon + cha_3mon;
		
		double jan = 81.36;
		double feb = jan + 0.71;
		double mar = feb - 0.43;
		/* 2. 계산 */
	    double avgWeight = (jan + feb + mar)/3;
		
	    /* 3. 출력 */
	    System.out.println(avgWeight + "kg");
	}

}
