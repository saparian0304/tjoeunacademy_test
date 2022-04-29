
public class EqualsEx2 {

	public static void main(String[] args) {
		
		String str1 = new String("abc");
		String str2 = new String("abc");
		
		if (str1 == str2) {
			System.out.println("str1 객체와 str2 객체는 같음");
		} else { 
			System.out.println("str1 객체와 str2 객체는 다름");
		}
		
		if (str1.equals(str2)) {
			System.out.println("str1 문자열과 str2 문자열은 같음");
		} else {
			System.out.println("str1 문자열과 str2 문자열은 다름");
		}
		
		// '==' 연산은 객체를 비교한다.
		// String.equals() 매서드는 문자열 값을 비교한다.
	}

}
