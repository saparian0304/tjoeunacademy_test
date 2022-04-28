package cloud;

public class Inches2Centimeters {
	public static void main(String[] args) {
		/* 1. 변수 생성 */
		int inch = 32;
		double inchToCm = 2.54;
		
		/* 2. 변환 */
		double cm = inch * inchToCm;
		
		/* 3. 출력 */
		System.out.println(cm+"cm");
	}
}
