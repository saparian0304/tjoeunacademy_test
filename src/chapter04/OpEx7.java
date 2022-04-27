package chapter04;

public class OpEx7 {
	
	public static void main(String[] args) {
		// 삼항연산자
		int score = 80;
		String pass = score >= 60 ? "합격" : "불합격";	// 조건식은 boolean 형태로 와야함
		System.out.println(score+"점은 "+pass);
		
		score = 50;
		pass = score >= 60 ? "합격" : "불합격";	
		System.out.println(score+"점은 "+pass);
		System.out.println();
		
		// 점수가 60이상이면 (점수가 90 이상이면 수석합격, 그렇지 않으면 합격) 
		// 60점 미만이면 불합격
		score = 92;
		pass = score >= 60 ? score >=90 ? "수석합격" : "합격" : "불합격";	
//		pass = score >= 60 ? (score >=90 ? "수석합격" : "합격") : "불합격";	
		System.out.println(score+"점은 "+pass);
		
		
		System.out.print("if문 출력1 : ");
		if (score >= 90) {
			pass = "수석합격";
		} else if (score >= 60) {
			pass = "합격";
		} else {
			pass = "불합격";
		}
		System.out.println(pass);
		
		System.out.printf("if문 출력2 : ");
		if (score >= 60) {
			if (score >= 90) {
				pass = "수석합격";
			} else {
				pass = "합격";
			}
		} else {
			pass = "불합격";
		}
		System.out.println(pass);
		System.out.println();
		
		
		// 문자열연산
		System.out.println(100 + "100");	// "100" + "100", 숫자를 자동형변환함
		System.out.println("1" + 1);		// "1" + "1"
		System.out.println("true" + true);	// "true" + "true" -> 자동 형변환함
		System.out.println(1+"1"+1+1+"1");
		System.out.println("1"+1+1);
		
		int age = 30;
		String age2 = age + ""; 	// 자동형변환을 일으키도록 함
		String age3 = String.valueOf(age);	// int를 String으로 변환하는 메서드(귀찮음)
	}

}
