package cloud;

public class Pork {

	public static void main(String[] args) {
		/* 1. 변수를 생성하시오. */
		int n = 3;
		
		/* 2. 메소드를 통한 칼로리를 계산하시오. */
		kcal(n);
		/* 3. 결과를 출력하시오 */
		System.out.printf("삼겹살 %d인분: %.2f kcal", n, kcal(n));
	}

	/* 4. 칼로리 계산을 위한 메소드를 작성하시오. */
	static double kcal(int n) {
		double kcal = 5.179;
		int a = 180;
		double result = kcal * n * a;
		return result;
	}
}
