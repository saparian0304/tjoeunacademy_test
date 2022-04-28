package cloud;

public class Main {
	public static void main(String[] args) {
		/* 1. 입력 값을 변수로 저장 */
		int num1 = Integer.parseInt(args[0]);
		int num2 = Integer.parseInt(args[1]);
		
		/* 2. 결과 출력 */
		System.out.printf("곱하기: %d x %d = %d%n", num1, num2, num1*num2);
		System.out.printf("나누기: %d / %d = %d%n", num1, num2, num1/num2);
		System.out.println("곱하기: " + num1 + " x " + num2 + " = " + num1*num2);
		System.out.println("나누기: " + num1 + " / " + num2 + " = " + num1/num2);
	}
}
