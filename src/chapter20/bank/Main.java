package chapter20.bank;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		AccountDAO dao = new AccountDAO();

		boolean run = true;
		while (run) {
			System.out.println("------------------------------------------");
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
			System.out.println("------------------------------------------");
			System.out.print("선택> ");

			int selectNo = scanner.nextInt();
			
			// 입력한 값에 따라 처리
			if (selectNo == 1) {		// 1. -> 계좌 생성
				dao.createAccount();
				
			} else if (selectNo == 2) {
				dao.accountList();		// 2. 계좌목록
			} else if (selectNo == 3) {
				dao.deposit();			// 3. 입금
			} else if (selectNo == 4) {
				dao.withdraw();			// 4. 출금
			} else if (selectNo == 5) {
				System.out.println("프로그램 종료");
				break;					// 5. 종료
			} else {
				System.out.println("다시 입력해주세요.");
			}
		}
		dao.close();
	}
}