package cloud;

public class Money {
	public static void main(String[] args) {
		// 변수 생성
		int a = 10000000;			// 원금
		double r = 0.03;		// 이율
		// 계산
//		int s = (int)(a*(1+r)*(1+r)*(1+r)*(1+r)*(1+r));
		int s = (int)(a*Math.pow((1+r), 5));
		// 출력
		System.out.printf("만기 금액: %d 원", s);
	}
	
	
}