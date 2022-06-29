package chapter03;

public class EscapeEx {
	// 변수의 범위(scope)
	int no;
	void main() {
		int no = 2;
		String name = "";
		no = 10;
	}
	
	void test() {
		String name = "홍길동";
		no = 20;
	}
	
	// 제어문자(escape 문자)
	public static void main(String[] args) {
		String greet = "안녕하세요, \n저는 \"홍길동\"입니다.";	// \n : 줄바꿈, \" : "
		String greet2 = "\t반갑습니다.\\";						// \t : 탭, \\ : \
		
		System.out.println(greet);
		System.out.println(greet2);
		
		/*
		 제어문자
		 \n	: 줄바꿈
		 \t : 탭
		 \\ : \
		 \' : '
		 \" : "
		 		 
		 */
	}

}
