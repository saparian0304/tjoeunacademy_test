package cloud;

public class Alba {

	public static void main(String[] args) {
		/* 1. 입력값 대입 */
		int wage, hour;
		wage = Integer.parseInt(args[0]);
		hour = Integer.parseInt(args[1]);
				
		/* 2. 월급 계산 */
	    int income = wage * hour;
		/* 3. 출력 */
	    System.out.println(income);

	}

}
