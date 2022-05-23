package omok;

import java.util.Scanner;

public class Omok {
	public static void main(String[] args) {
		Player user = new Player("사용자", "O");
		Player computer = new Player("컴퓨터", "X");
		Board board = new Board(19);
		play(board, user, computer);
		
	
		// 번갈아 놓기...
		Player putter = computer;
		while (true) {
			putter = putter == user ? computer : user;
			Scanner sc = new Scanner(System.in);
			// 돌 입력
			String str = sc.nextLine();
			str=str.toUpperCase();
			// 돌 놓기
			board.map[Integer.valueOf(str.substring(1))][str.charAt(0)-65] = putter.stone;
			board.print();
			
			// 오목 여부 확인
			if (board.checkWidth(putter.stone) || board.checkHeight(putter.stone) 
					||board.checkCross1(putter.stone) || board.checkCross2(putter.stone)) {
				System.out.printf("%s의 승리입니다. \n경기 종료", putter.name);
				break;
			}
		}
		
	}

	private static void play(Board board, Player user, Player computer) {
		board.print();
	}
	
	
	
	
}