package cloud;

public class Walking {
	public static void main(String[] args) {
		/* 1. 칼로리 계산을 위해 메소드를 호출하시오. */
		double cal = walkKcal(5000);
		/* 3. 결과를 출력하시오. */
		System.out.println("소모 칼로리: " + cal + " kcal");
	}

	/* 2. 칼로리 계산 메소드를 정의하시오. */
	/**
	 * 
	 * @param pace 걸음 수
	 * @return 소모된 칼로리
	 */
	public static double walkKcal(int pace) {
		double result = 0.02 * pace;
		return result;
		
	}
}