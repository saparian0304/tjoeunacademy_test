package chapter11;

public class ExceptionEx0 {

	public static void main(String[] args) {

		System.out.println(1);
		try {
		System.out.println(2);
		System.out.println(3/0);	// 예외발생 -> catch문으로 이동
		System.out.println(4);		// 실행 X
		} catch (ArithmeticException e1) {
			System.out.println(5);	// 예외 발생시 실행
		}
		System.out.println(6);

	}
}
