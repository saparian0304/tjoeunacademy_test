package chapter09;

public class Complexer implements Fax, Printer, Scanner {

	@Override	
	public void scan() {
		System.out.println("스캔 실행");
	}

	@Override
	public void print() {
		System.out.println("출력 실행");
	}

	// 컴파일러에게 상위클래스의 메서드를 override하고 있다고 알려주는 표시
	// 잘못된 override인 경우 에러를 표시해줌 (overload하는 실수를 막을 수 있음)
	@Override	
	public void send(String tel) {
		System.out.println(FAX_NUMBER + "에서 " + tel + "로 FAX 전송");
	}

	@Override
	public void receive(String tel) {
		System.out.println(tel + "에서 " + FAX_NUMBER + "로 FAX 수신");
	}

}
