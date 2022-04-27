package chapter05;

public class Test {

	public static void main(String[] args) {
		int score = 90;
		String pass;
		if (score >= 60) {
			pass = "합격";
		} else {
			pass = "불합격";
		}
		
		System.out.println("당신은 " + pass + "입니다.");
		
	}

}
