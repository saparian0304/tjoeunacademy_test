package cloud;

public class Fibonacci {

	public static void main(String[] args) {
		// 배열 생성
		int[] fibo = new int[10];

		// 피보나치 배열 작성
		writeFibonacci(fibo);

		// 결과 출력
		printFibonacci(fibo);
	}

	// 입력받은 정수형 배열을 피보나치 수열로 채움
	public static void writeFibonacci(int[] arr) {
		// 피보나치 배열 초기값 설정
		arr[0] = 0;
		arr[1] = 1;

		// 나머지 배열 작성
		for (int i = 2; i < arr.length; i++) {
			/* 1. 해당 반복문을 완성하세요. */
			arr[i] = arr[i-2] + arr[i-1];
		}
	}

	// 입력받은 정수형 배열을 출력
	public static void printFibonacci(int[] arr) {
		System.out.printf("피보나치 수열: [ ");
		for (int i = 0; i < arr.length; i++) {
			/* 2. 해당 반복문을 완성하세요. */
			System.out.printf("%d",arr[i]);
			if (i != arr.length-1)
				System.out.printf(", ");
		}
		System.out.printf(" ]");
	}
}
