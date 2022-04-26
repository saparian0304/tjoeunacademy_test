package chapter04;

public class Excer5 {

	public static void main(String[] args) {
		/*
		 * 1. 연도를 4로 나누어 떨어지면 윤년
		 * 2. 100으로 나누어 떨어지는 연도는 윤년이 아님
		 * 3. 400으로 나누어 떨어지면 윤년
		 */
		
		int year = 2020;
		
		boolean leapYear = year%400==0 || (year%100!=0 && year%4==0);
		
		// 윤년이면 true, 윤년이 아니면 false
		
		System.out.println(leapYear);
	}

}
