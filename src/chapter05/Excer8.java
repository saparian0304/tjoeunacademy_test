package chapter05;

import java.util.Scanner;

public class Excer8 {

	public static void main(String[] args) {
		/*
		 숫자 맞히기 게임
		 
		 컴퓨터가 1부터 100사이의 임의의 정수(답)를 정함
		 사용자가 그 숫자를 입력
		 입력한 숫자와 답을 비교해서 적을수를 입력했으면 "큰 수를 입력하세요" 출력
		 큰 수를 입력했으면 "작은 수를 입력하세요" 출력
		 정답이면 "정답입니다. 시도횟수 0회" 출력 -> 게임끝
		
		 */
		
		int answer = (int)(Math.random() * 100) + 1;
		Scanner sc = new Scanner(System.in);
		int count = 0;
		while (true) {
			int num = sc.nextInt();
			count++;
			if (num < answer)
				System.out.println("큰 수를 입력하세요");
			else if (num > answer) 
				System.out.println("작은 수를 입력하세요");
			else {
				System.out.println("정답입니다. 시도횟수 " + count + "회 ");
				break;
			}
		}
		
	}

}
