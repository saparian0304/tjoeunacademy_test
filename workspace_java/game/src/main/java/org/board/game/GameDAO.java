package org.board.game;

import org.springframework.stereotype.Repository;

@Repository
public class GameDAO {
	
	/**
	 * 19x19 보드판 생성
	 * @return String[19][19]
	 */
	public String[][] initBoard() {
		String[][] board = new String[19][19];
		for (int row = 0; row < 19; row++) {
			for (int col = 0; col < 19; col++) {
				board[row][col] = ".";
			}
		}
		return board;
	}
	
	/**
	 * 
	 * @param     board판
	 * @param     오목여부를 판단하고 싶은 돌
	 * @return    오목 성공시 true 리턴
	 */
	public boolean goal(String[][] board, String stone) {
		boolean flag = false;
		
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j <board.length-4; j++) {
				if(board[i][j].equals(stone) &&
					board[i][j+1].equals(stone) &&
					board[i][j+2].equals(stone)&&
					board[i][j+3].equals(stone) &&
					board[i][j+4].equals(stone)){
					flag = true;
				}
			}
		}
		
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j <board.length-4; j++) {
				if(board[i][j].equals(stone) &&
					board[i+1][j].equals(stone) &&
					board[i+2][j].equals(stone)&&
					board[i+3][j].equals(stone) &&
					board[i+4][j].equals(stone)){
					flag = true;
				}
			}
		}
		
		for(int i = 0; i < board.length-4; i++) {
			for(int j = 0; j <board.length-4; j++) {
				if(board[i][j].equals(stone) &&
					board[i+1][j+1].equals(stone) &&
					board[i+2][j+2].equals(stone)&&
					board[i+3][j+3].equals(stone) &&
					board[i+4][j+4].equals(stone)){
					flag = true;
				}
			}
		}
		
		for(int i = 4; i < board.length; i++) {
			for(int j = 0; j < board.length-4; j++) {
				if(board[i][j].equals(stone) &&
					board[i-1][j+1].equals(stone) &&
					board[i-2][j+2].equals(stone) &&
					board[i-3][j+3].equals(stone) &&
					board[i-4][j+4].equals(stone)) {
					flag = true;
				}
			}
		}
		return flag;
	}
}
