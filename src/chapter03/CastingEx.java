package chapter03;

public class CastingEx {

	public static void main(String[] args) {
		int a = 10;
		long b = a;	// 형변환이 발생 (자동형변환)
//		int c = b;	// 대입불가, 형변환이 일어나지 못함

		// 강제 형변환
		int c = (int)b;
		System.out.println(c);
		
		double d = a;	// 자동형변환
		
		double pi = 3.14;
		int pi2 = (int)pi;	// 강제형변환
		System.out.println(pi2);	// 3이 출력됨. 값의 손실이 발생
		
		int kor = 90;
		int eng = 80;
		int math = 90;
		// 합계점수
		int total = kor + eng + math;
		System.out.println(total);
		// 평균점수
//		double avg = total / 3;			// 86이 출력. 정수와 정수의 연산결과값은 정수이다.
		double avg = (double)total / 3;	// double로 강제형변환 후 나누기, 86.6666~
		System.out.println(avg);
		
		CastingEx aa;
		
//		int tel = 01012345678;		// 범위를 벗어남
//		long tel = 01012345678L;	// 앞에 0이 포함되어있음
		String tel = "010-1234-5678";	// 앞에 '0', '-' 사용으로 인해 정수형 사용 불가
		String price = "5,000";		// ','가 들어가 있으면 정수형으로 사용 불가
	}

}
