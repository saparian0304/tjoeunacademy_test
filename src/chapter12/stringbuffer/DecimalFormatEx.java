package chapter12.stringbuffer;

import java.text.DecimalFormat;

public class DecimalFormatEx {

	public static void main(String[] args) {
		DecimalFormat df1 = new DecimalFormat("###,###.##");	// 입력된 자리수 만큼만 출력
		DecimalFormat df2 = new DecimalFormat("000,000");		// 자리수가 고정되서 출력
		
		System.out.println(df1.format(5500));	//   5,500
		System.out.println(df2.format(5500));	// 005,500

		System.out.println(df1.format(5500000));	// 5,500,000
		System.out.println(df2.format(5500000));	// 5,500,000
	}
}
