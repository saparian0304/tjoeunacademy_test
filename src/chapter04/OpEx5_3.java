package chapter04;


// & 와 && 연산자의 차이 (shortcut)
public class OpEx5_3 {

	public static void main(String[] args) {
		String name = null;
		// name이 null일때
		
		// &
		// 양쪽항을 다 연산하기 때문에 에러가 발생함
		if (name != null & name.equals("관리자")) {
			System.out.println("당신은 관리자입니다.");
		}
		
		// &&
		// 왼쪽항만 연산하고 넘어가기때문에 에러가 발생하지 않음
		if (name != null && name.equals("관리자")) {
			System.out.println("당신은 관리자입니다.");
		}
		
		
	}
}
