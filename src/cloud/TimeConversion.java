package cloud;

public class TimeConversion {

	public static void main(String[] args) {
		/* 1. 변수 생성 */
		int totalSec = 7582;
		int hour, min, sec;
		
		/* 2. 변환 */
		hour = totalSec / 3600;
		min = totalSec % 3600 / 60;
		sec = totalSec % 60;
	    /* 3. 출력 */
		System.out.println(hour + "시간 " + min + "분 " + sec + "초");

	}

}
