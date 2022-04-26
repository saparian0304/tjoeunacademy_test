package chapter04;

public class Excer4 {

	public static void main(String[] args) {
		/*
		 * 6세 이상 탑승 가능 (120cm 이상시 보호자 동반하에 탑승 가능)
		 * 키 120cm 이상 가능
		 * 심장관련 질환자 탑승 불가
		 */
		
		int age = 6;
		int height = 110;
		boolean parent = false;
		boolean heartDease = false;
		
		
		System.out.println(heartDease==false && 
				((height>=120 && age >=6 )|| height>=120 && age <6 && parent)
				? "탑승가능" : "탑승불가");
	}

}
