package chapter03;

public class PrimitiveType {
	// 기본자료형 - 정수형, 논리형
	public static void main(String[] args) {
		// 정수형 : int, long
		// 21억이 넘으면 int를 사용할 수 없다. (정확히는 2,147,483,647)
		int a = 2100000000;	
		// 21억 이상은 long 사용 
		long a1= 2200000000L; // int와 구분을 위해 숫자 뒤에 L을 붙임
		
		// byte의 범위 (-128~127)
		// byte 연산시 int형으로 변경됨 -> 사용할 필요 X
		byte ban = 1;
//		byte c = ban * ban;		// 연산 후 int 변환되어 오류 발생

		// 논리형 : ture / false 
		boolean b = false; // 기본값은 false이고, 소문자로 작성해야함.
		
	}

}
