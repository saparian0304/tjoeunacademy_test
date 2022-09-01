package chapter05;

import java.util.Scanner;


public class SwitchEx {

	public static void main(String[] args) {
		System.out.println("점수를 입력하세요");
		Scanner scan = new Scanner(System.in);
		
		int score = scan.nextInt();
		String grade = "";
		
		switch (score / 10) {
			case 9 :
				grade = "A";
				System.out.println("학점 : " + grade);
				break;
			case 8 :
				grade = "B";
				System.out.println("학점 : " + grade);
				break;
			case 7 : 
				grade = "C";
				System.out.println("학점 : " + grade);
				break;
			case 6 :
				grade = "D";
				System.out.println("학점 : " + grade);
				break;
			default : 
				grade = "F";
		}
		System.out.println("학점 : " + grade);
	}
}
