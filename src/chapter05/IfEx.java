package chapter05;

public class IfEx {

	public static void main(String[] args) {

		int score = 90;

		System.out.println("시험 시작");
		System.out.println("시험점수 : " + score);
		if (score >= 60) {
			System.out.println("합격입니다.");
			if (score == 100) {
				System.out.println("만점입니다.");
			}
		} else {
			System.out.println("불합격입니다.");
		}

		System.out.println("시험 끝");
		System.out.println();
		System.out.println();

		score = 40;
		System.out.println("시험 시작");
		System.out.println("시험점수 : " + score);
		if (score >= 60) {
			System.out.println("합격입니다.");
			if (score == 100) {
				System.out.println("만점입니다.");
			}
		} else {
			System.out.println("불합격입니다.");
		}

		System.out.println("시험 끝");
		System.out.println();
		System.out.println();

		score = 100;
		System.out.println("시험 시작");
		System.out.println("시험점수 : " + score);
		if (score >= 60) {
			System.out.println("합격입니다.");
			if (score == 100) {
				System.out.println("만점입니다.");
			}
		} else {
			System.out.println("불합격입니다.");
		}
		System.out.println("시험 끝");

		System.out.println();
		System.out.println();

		// 실행문이 하나인 경우에는 중괄호 생략이 가능
		// 하지만 가능하면 쓰는게 구분하기 쉬움
		if (score >= 60)
			System.out.println("합격");
		else
			System.out.println("불합격");
	}

}
