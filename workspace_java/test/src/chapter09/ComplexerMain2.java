package chapter09;

public class ComplexerMain2 {
	// 익명 구현객체
	public static void main(String[] args) {
		
		// 인터페이스를 실행할 클래스에서 직접 구현해서 사용하는 것
		// 따로 인터페이스를 구현하는 클래스를 만들 필요가 없음
		Fax fax = new Fax() {

			@Override
			public void send(String tel) {
				System.out.println("여기는 익명 구현 객체의 send()");
			}

			@Override
			public void receive(String tel) {
				System.out.println("여기는 익명 구현 객체의 receive()");
			}
		};
		
		fax.send("1234");
		fax.receive("5678");
		
		// 다시 객체를 만드려면 또 구현을 해야함 & 다중구현이 안됨
		// 여러번 쓰려면 클래스 파일을 만들어서 만드는게 좋음
//		Fax fax2 = new Fax();
	}

}
