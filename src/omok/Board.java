package omok;

public class Board {
	int size;
	String[][] map;

	Board(int size) {
		this.size = size;
		map = new String[size][size];
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				map[row][col] = ".";
			}
		}
	}

	public void print() {
		for (int row = 0; row < size; row++) {
			System.out.printf("%2d", row);
			for (int col = 0; col < size; col++) {
				System.out.print(" " + map[row][col]);
			}
			System.out.println();
		}
		System.out.println("   A B C D E F G H I J K L M N O P Q R S");
	}

	// 가로 5개 확인하기
	boolean checkWidth(String str) {
		boolean flag = false;
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 15; j++) {
				if(str == map[i][j] && str == map[i][j+1] && str == map[i][j+2]
						&& str == map[i][j+3] & str == map[i][j+4]) {
					flag = true;
				} ;
			}
		}
		return flag;
	}
	
	// 세로 5개 확인하기
	boolean checkHeight(String str) {
		boolean flag = false;
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 19; j++) {
				if(str == map[i][j] && str == map[i+1][j] && str == map[i+2][j]
						&& str == map[i+3][j] & str == map[i+4][j]) {
					flag = true;
				} ;
			}
		}
		return flag;
	}
	
	// 대각선 5개 확인하기\
	boolean checkCross1(String str) {
		boolean flag = false;
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				if(str == map[i][j] && str == map[i+1][j+1] && str == map[i+2][j+2]
						&& str == map[i+3][j+3] & str == map[i+4][j+4]) {
					flag = true;
				} ;
			}
		}
		return flag;
	}
	
	// 대각선 5개 확인하기/
	boolean checkCross2(String str) {
		boolean flag = false;
		for (int i = 4; i < 19; i++) {
			for (int j = 0; j < 15; j++) {
				if(str == map[i][j] && str == map[i-1][j+1] && str == map[i-2][j+2]
						&& str == map[i-3][j+3] & str == map[i-4][j+4]) {
					flag = true;
				} ;
			}
		}
		return flag;
	}

}