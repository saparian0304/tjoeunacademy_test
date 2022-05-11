package chapter04;

public class Excercise4 {

	public static void main(String[] args) {
		int age = 6;
		int height = 121;
		boolean parent = false;
		boolean heartDease = false;
		
		// 심장 질환이 있으면 불가
		// 키 120cm 이상이면 가능
		// 6세 이상이면 가능 (단, 6세 이하여도 키가 120cm 이상이면 보호자 동반하에 가능)
		
		//삼항연산자로 풀기
		String result;
		result = (heartDease == false && height >= 120) ? (age >= 6 || parent == true) ? "가능": "불가": "불가" ;
		System.out.println(result);
		
		
		// if문으로 풀기
		String result2;
		if (heartDease == false && height >= 120) {
			if (age >= 6 || parent == true) {
				result2 = "가능";
			} else {
				result2 = "불가";
			}
		} else {
			result2 = "불가"; 
		}
		
		System.out.println(result);

	}

}
