package org.board.game;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface GameService {

	public String check(GameDTO dto, HttpServletRequest req, HttpServletResponse resp);
}
