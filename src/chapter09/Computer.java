package chapter09;

public class Computer {

	public static void main(String[] args) {
		
		GraphicCard gc = new Amd();
		
		System.out.println("메모리 : " + gc.MEMORY);
		
		// Amd로 생성
		gc = new Amd();	// 자동 형변환 (Amd -> GraphicCard)
		gc.process();
		
		// Nvidia로 교체
		gc = new Nvidia();	// 자동 형변환 (Nvidia -> GraphicCard)
		gc.process();
		
		// 매개변수의 다형성 - 구현
		display(gc);
		display(new Amd());
		// 매개변수의 다형성 -> 매개변수 속에 익명구현객체를 새로 생성
		display(new GraphicCard() {
			public void process() {
				System.out.println("내가 만든 그래픽카드");
			};
		});
		// 리턴타입이 익명구현객체인 경우
		gc = display();
		gc.process();
		
		// 매개변수 타입이 Object로 받고 Amd로 형변환해서 실행하는 메서드
		test(new Amd());
		test(new Nvidia());		// instanceof 메서드로 타입판정을 하지 않으면 실행시 에러남 
	}
	
	// 매개변수의 다형성
	static void display(GraphicCard gc) {
		gc.process();
	}
	// 리턴타입에도 익명구현객체를 리턴할 수 있다.
	static GraphicCard display() {
		
		return new GraphicCard() {
			public void process() {
				System.out.println("리턴값에 익명객체 구현");
			}
		};
	}
	
	
	// 매개변수를 Object로 받아서 다시 Amd로 형변환
	// Amd였던 참조변수만 실행이 됨
	static void test(Object obj) {
		if (obj instanceof Amd)		// Amd 객체인지를 확인하는 과정
			((Amd)obj).process();
		else System.out.println("실행 불가");
	}
	
	
}
