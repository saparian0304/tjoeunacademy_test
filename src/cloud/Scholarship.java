package cloud;

public class Scholarship {
	public static void main(String[] args) {
		// 메소드 호출
		printTest("Park", 100, 92); // Park => 전액 장학금!

		/* 3. 모든 학생의 결과를 출력하시오. */
		// printTest("Kim", 82, 96); // Kim => 반액 장학금!
		// printTest("Choi", 82, 88); // Choi => 다음 기회에~
		printTest("Kim", 82, 96);
		printTest("Choi", 82, 88);
	}

	public static void printTest(String name, int math, int eng) {
	    // 변수 생성
	    String result = "";
	    
	    // 조건에 따른 값 변경
	    if (math >= 90 && eng >= 90) {
	      result = "전액 장학금!";
	    } else if (math >= 90 || eng >= 90) {
	      result = "반액 장학금!";
	    } else {
	      result = "다음 기회에~";
	    }
	    
	    // 결과 출력
	    System.out.printf("%s => %s\n", name, result);
	  }
}