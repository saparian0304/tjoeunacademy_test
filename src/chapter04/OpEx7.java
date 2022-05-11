package chapter04;

// 삼항연산자
public class OpEx7 {

	public static void main(String[] args) {
		
		int score = 80;
		// (조건식 ? 값1 :값2 )
		// 조건식이 true이면 값1, false면 값2를 반환
		String pass = score >= 60 ? "합격" : "불합격";
		System.out.println(pass);
		
		// 간단한 조건식을 구현할때 if문 대신해서 사용할 수 있음
		
		// 문자열 연산 : +
		int age = 30;
//		String age2 = age; // 타입이 다르기 때문에 대입을 하지 못함
		// String.valueOr() : 정수형 -> String으로 변환해주는 메서드
		String age2 = String.valueOf(age);
		String age3 = age + ""; // 문자열 연산을 통해 자동형변환이 되는 것을 이용한 방법
	}

}
