package cloud;

public class ProgrammingGrades {
	public static void main(String[] args) {
		// 변수 생성
		int score1 = 96;
		int score2 = 85;
		int score3 = 76;
		
		// 결과 출력
		System.out.printf("%d점 -> %s\n", score1, grade(score1));
		System.out.printf("%d점 -> %s\n", score2, grade(score2));
		System.out.printf("%d점 -> %s\n", score3, grade(score3));
	}
	
	public static String grade(int score) {
		// 메소드를 완성하시오
		String result;
		if (score/10 >= 9) {
			result = (score >= 95) ? "A+" : "A0";
		} else if (score >= 70) {
			result = score >= 80 ? "B+" : "B0";
		} else { 
			result = "C+";
		}
		
		return result;
	}
}
