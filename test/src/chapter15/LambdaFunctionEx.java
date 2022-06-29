package chapter15;

public class LambdaFunctionEx {

	public static void main(String[] args) {
		// 함수적 인터페이스를 이용해서 람다식을 구현할 수 있음 -> 코드가 간결해짐 (익명함수)
//		InterfaceEx ie = (int x, int y) -> x + y;
//		InterfaceEx ie = (x,y) -> {
//			return x + y;
//		};
		InterfaceEx ie = (x,y) -> x + y;
		
		System.out.println(ie.sum(1,2));
		
		calculate(() -> System.out.println("실행"));
		
	}

	public static void calculate(TestInterface ex) {
		ex.run();
	}
}

@FunctionalInterface
interface InterfaceEx {
	public int sum(int x, int y);
	// 추상메서드가 더 있으면 람다식을 이용할 수 없다
	//	public int sum2();
}

interface TestInterface {
	void run();
}