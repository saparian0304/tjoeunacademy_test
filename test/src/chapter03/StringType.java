package chapter03;

public class StringType {
	// 참조자료형 - 문자열
	public static void main(String[] args) {
		String name;		// 변수 선언
		name = "홍길동";	// 변수 초기화
		
		String name2 = "홍길동";	// 선언과 동시에 초기화
		String name3 = null;		// null 값으로 초기화 => 값이 존재하지 않음
		String name4 = "";			// 빈 문자열로 초기화 => 값이 존재함
		
		System.out.println("name2=" + name2);
		System.out.println("name3=" + name3);
		System.out.println("name4=" + name4);
			
		// 문자열 메서드 : charAt()
		String text = "Hello java";
		System.out.println(text.charAt(0));	// charAt() : 해당 index에 있는 char를 반환함 
		System.out.println(text.charAt(1));	// String 자료형 각각은 char형태로 저장됨
		System.out.println(text.charAt(2));
		
		System.out.println("name님 안녕하세요"); // "" 안에 있으면 모두 문자열 자료형임 
		System.out.println(name + "님 안녕하세요");
	}

}
