package cloud;

public class Lab03Review {
	public static void main(String[] args) {
		/* 1. 문자열을 실수로 변환하세요. */
		double temF = Double.parseDouble(args[0]);
		
		/* 2. 화씨온도를 섭씨로 변환하세요. */
		double temC = (temF - 32.0) / 1.8;
		
		/* 3. 결과를 출력하세요. */
		System.out.println("화씨 " + temF + "도는 섭씨로 " + temC + "도 입니다!");
	}
}
