package chapter04;

public class OpEx2 {
	public static void main(String[] agrs) {
		// 사칙연산 : +, -, *, /
		int a = 5+5;
		System.out.println("5 + 5 = " + a);
		
		int b = a - 5;
		System.out.println("10 - 5 = " + b);
		
		int c = b * 2;
		System.out.println("5 * 2 = " + c);

		int d = c / 5;
		System.out.println("10 / 5 = " + d);
		// % : 나머지 연산자
		int e = 10 % 3;
		System.out.println("10 % 3 = " + e);
		
		// 나눗셈 연산자 사용시 조심해야함
		int kor = 95;
		int eng = 85;
		int math = 76;
		int count = 3;
		double avg = (kor + eng + math) / count;	// 잘못된 연산 : 우측 연산결과가 이미 int형임
		System.out.println(avg);
		// 자동 형변환이 될 수 있게 만들어야함 
		avg = (double)(kor + eng + math) / 3.0;
		System.out.println(avg);
		avg = (double)(kor + eng + math) / count;
		System.out.println(avg);
		avg = (kor + eng + math) / (double)count;
		System.out.println(avg);
		
		int a2 = -5;
		System.out.println("d d g"+ -a2);  	// 이런식으로는 잘 사용 안함 (혼동의 여지 있음)
		System.out.println("d d g"+ a2 * -1);
	}
}
