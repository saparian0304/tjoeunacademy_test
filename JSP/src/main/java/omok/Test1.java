package omok;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/test.do")
public class Test1 extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		
		String col = req.getParameter("col");
		String row = req.getParameter("row");
		int rowNum = Integer.parseInt(req.getParameter("num"));
		
		col = col.substring(3);
		row = row.substring(3);
		
		System.out.println("col : " + col);
		System.out.println("row : " + row);
		HttpSession session = req.getSession(true);
		if(session.getAttribute("arr") == null) {
			String[][] a = new String[19][19];
			for (int r = 0; r < 19; r++) {
				for (int c = 0; c < 19; c++) {
					a[r][c] = ".";
				}
			}
			session.setAttribute("arr", a);
		}
		boolean win = true;
		String str = "";
		PrintWriter out = resp.getWriter();
		
		String[][] getArr = (String[][])session.getAttribute("arr");
		
		if(rowNum % 2 == 0) {
			getArr[Integer.parseInt(row)][Integer.parseInt(col)] = "O";
			session.setAttribute("arr", getArr);
			win = goal(getArr, "O");
			
			if (win == false) {
				str = "백돌 승리";
				System.out.println("백돌의 승리입니다.");
			}
			
		} else {
			getArr[Integer.parseInt(row)][Integer.parseInt(col)] = "X";
			session.setAttribute("arr", getArr);
			win = goal(getArr, "X");
			
			if (win == false) {
				str = "흑돌 승리";
				System.out.println("흑돌의 승리입니다.");
				
			}
			
		}
		out.print(str);
		
	}
	
	public static boolean goal(String[][] getArr, String stone) {
		boolean flag = true;
		
		for(int i = 0; i < getArr.length; i++) {
			for(int j = 0; j <getArr.length-4; j++) {
				if(getArr[i][j].equals(stone) &&
					getArr[i][j+1].equals(stone) &&
					getArr[i][j+2].equals(stone)&&
					getArr[i][j+3].equals(stone) &&
					getArr[i][j+4].equals(stone)){
				
					flag = false;
				}
			}
		}
		
		for(int i = 0; i < getArr.length; i++) {
			for(int j = 0; j <getArr.length-4; j++) {
				if(getArr[i][j].equals(stone) &&
					getArr[i+1][j].equals(stone) &&
					getArr[i+2][j].equals(stone)&&
					getArr[i+3][j].equals(stone) &&
					getArr[i+4][j].equals(stone)){
					
					flag = false;
				}
			}
		}
		
		for(int i = 0; i < getArr.length-4; i++) {
			for(int j = 0; j <getArr.length-4; j++) {
				if(getArr[i][j].equals(stone) &&
					getArr[i+1][j+1].equals(stone) &&
					getArr[i+2][j+2].equals(stone)&&
					getArr[i+3][j+3].equals(stone) &&
					getArr[i+4][j+4].equals(stone)){
					
					flag = false;
				}
			}
		}
		
		for(int i = 4; i < getArr.length; i++) {
			for(int j = 0; j < getArr.length-4; j++) {
				if(getArr[i][j].equals(stone) &&
					getArr[i-1][j+1].equals(stone) &&
					getArr[i-2][j+2].equals(stone) &&
					getArr[i-3][j+3].equals(stone) &&
					getArr[i-4][j+4].equals(stone)) {
					
					flag = false;
				}
			}
		}
		
		return flag;
	}
	
}