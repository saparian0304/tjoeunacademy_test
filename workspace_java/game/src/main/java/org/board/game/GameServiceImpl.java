package org.board.game;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {
	
	@Autowired
	GameDAO dao;
	
	/**
	 * 오목 성공시 승리문구 리턴
	 */
	public String check(GameDTO dto, HttpServletRequest req, HttpServletResponse resp) {
		String result = "";
		
		// 파라미터로 받은 자료 형변환
		int col = Integer.parseInt(dto.getCol().substring(3));
		int row = Integer.parseInt(dto.getRow().substring(3));
		int stoneNum = Integer.parseInt(dto.getStoneNum());
		
		// 세션 정보 받기
		HttpSession session = req.getSession(true);
		
		// 첫돌이 놓이면 보드판 생성
		if(session.getAttribute("board") == null) {
			session.setAttribute("board", dao.initBoard());
		}
		
		// 세션에 적힌 돌 정보 받아오기
		String[][] board = (String[][])session.getAttribute("board");
		
		
		boolean win = false;
		if(stoneNum % 2 == 0) {		// 백돌일때
			// 파라미터로 받은 백돌 위치정보 보드판에 입력 후 세션에 저장
			board[row][col] = "O";
			session.setAttribute("board", board);
			
			// 오목 성공 여부 판단
			win = dao.goal(board, "O");
			if (win == true) {
				result = "백돌의 승리입니다.";
			}
		} else {	// 흑돌일때
			// 파라미터로 받은 흑돌 위치정보 보드판에 입력 후 세션에 저장
			board[row][col] = "X";
			session.setAttribute("board", board);
			
			// 오목 성공 여부 판단
			win = dao.goal(board, "X");
			if (win == true) {
				result = "흑돌의 승리입니다.";
			}
		}
		
		System.out.println("col : " + col);
		System.out.println("row : " + row);
		System.out.println("출력 : " + result);
		
		return result;
	}
}
