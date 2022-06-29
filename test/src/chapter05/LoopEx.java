package chapter05;

import java.util.Scanner;
// 무한반복문
public class LoopEx {

	public static void main(String[] args) {
		/*
		 for : 반복횟수가 정해져 있을 때
		 
		 while : 반복횟수가 정해져 있지 않을 때
		 */
		
		
		// 무한반복문
//		while (true) {
//			Scanner scan = new Scanner(System.in);
//			System.out.println("숫자를 입력하세요(9는 종료)");
//			int number = scan.nextInt();
//			if (number == 9) break;			// 해당 조건 만족시 반복문 탈출
//		}
//		System.out.println("끝");

		boolean flag = true;
		while (flag) {
			Scanner scan = new Scanner(System.in);
			System.out.println("숫자를 입력하세요(9는 종료)");
			int number = scan.nextInt();
			if (number == 9) flag = false;			// 해당 조건 만족시 반복문 탈출
		}
		System.out.println("끝");
	}

}
