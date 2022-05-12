package chapter04;

public class Excercise5 {

	public static void main(String[] args) {
		
		int year = 2020;
		
		boolean leapYear = year % 400 == 0 ? true : year % 100 != 0 && year % 4 == 0 ? true : false;
				
		// 윤년이면 true, 윤년이 아니면 false
		System.out.println(leapYear);
		
		// 다른 방법
		boolean leapYear2 = year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
		System.out.println(leapYear2);
		
	}

}
