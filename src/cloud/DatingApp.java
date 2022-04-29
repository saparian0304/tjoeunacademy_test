package cloud;

public class DatingApp {

	public static void main(String[] args) {
		// 평가
	    String x = rating(4.2, 4.7, 4.3);
	    String y = rating(3.8, 4.1, 3.5);
	    String z = rating(3.6, 3.0, 3.4);
	    
	    // 출력
	    System.out.printf("X -> %s등급\n", x);
	    System.out.printf("Y -> %s등급\n", y);
	    System.out.printf("Z -> %s등급\n", z);

	}

	public static String rating(double personality, double look, double ability) {
		String result = "";
		double sum = personality + look + ability;
		int count = 0;
		if (personality >= 4.0) count++;
		if (look >= 4.0) count++;
		if (ability >= 4.0) count++; 
		
		if (count >= 3) {			// 모든 요소가 4.0 이상
			result = "A";
		} else if (count >= 1 && sum >= 10) {	// 모든 요소의 총 합이 10 이상, 적어도 하나의 요소는 4.0 이상
			result = "B";
		} else {					// 그외  
			result = "C";
		}
		return result;
	}
}
