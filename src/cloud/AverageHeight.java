package cloud;

public class AverageHeight {
	public static void main(String[] args) {
		test(176.3, true); // 176.3cm, 남 => 평균키 이상
		test(162.7, false); // 162.7cm, 여 => 평균키 이상
		test(171.8, true); // 171.8cm, 남 => 평균키 이하
		test(158.4, false); // 158.4cm, 여 => 평균키 이하
	}

	public static void test(double height, boolean isMale) {
	    // 변수 생성
	    String gender = "";
	    String result = "";

	    // 조건 처리
	    if (isMale) {
	      gender = "남";
	      if (height >= 173.5 ) {
	        result = "이상";
	      } else {
	        result = "이하";
	      }
	    } else {
	      gender = "여";
	      if (height >= 160.8) {
	        result = "이상";
	      } else {
	        result = "이하";
	      }
	    }

	    // 결과 출력
	    System.out.printf("%.1fcm, %s => 평균키 %s\n", height, gender, result);
	  }
}
