package chapter04;

public class OpEx2 {

	public static void main(String[] args) {
		int e = 10 % 3;
		System.out.println(e);
		System.out.println(10 % 3);
		
		// 부호연산 
		// '+' * '+' = '+'
		// '+' * '-' = '-'
		// '-' * '+' = '-'
		// '-' * '-' = '+'
		int a = -5;
		System.out.println("a = "+-a);		// -(-5), 코드가 헷갈리기때문에 잘 사용하지는 않음
		System.out.println("a = "+ a*-1);
	}
}
