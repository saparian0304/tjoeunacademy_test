package calendar;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public static String getAddDate(String date, int days) {
		String[] dateArr = date.split("-");
		int year = Integer.parseInt(dateArr[0]);
		int month = Integer.parseInt(dateArr[1]);
		int day = Integer.parseInt(dateArr[2]);
		
		Calendar cal = Calendar.getInstance();
		cal.set(year, month-1, day);
		
		cal.add(Calendar.DATE, days);
		
		String monthStr = "";
		if (cal.get(Calendar.MONTH) + 1 < 10) {
			monthStr = "0" + (cal.get(Calendar.MONTH) + 1);
		} else {
			monthStr = ""+ (cal.get(Calendar.MONTH) + 1);
		}
		
		String dayStr = "";
		if (cal.get(Calendar.DATE) + 1 < 10) {
			dayStr = "0" + (cal.get(Calendar.DATE));
		} else {
			dayStr = ""+ (cal.get(Calendar.DATE));
		}

		return cal.get(Calendar.YEAR) + "-" + monthStr + "-" + dayStr;
	}
	
	
	public static void main(String[] args) {

		for (int i=0; i<=100; i++)
			System.out.println(getAddDate("2022-08-25", i));
	}
	
	
}
