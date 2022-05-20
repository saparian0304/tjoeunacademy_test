package chapter13.practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Bank {
	private List<Account> accountList = new ArrayList<Account>();

	// 계좌생성
	public void createAccount() {
		System.out.println("-----------------");
		System.out.println("계좌생성");
		System.out.println("-----------------");

		// 계좌를 생성할 Account 객체 생성
		Account customer = new Account();
		Scanner sc = new Scanner(System.in);
//		
//		// 새로 만들 계좌 정보 입력
		System.out.print("계좌번호 : ");
		String num = sc.next();

		// 계좌번호 입력 유효성 체크
		try {
			Integer.parseInt(num);
		} catch (Exception e) {
			System.out.println("숫자를 입력해주세요");
			return;
		}
		
		// 이미 존재하는 계좌번호인지 체크
		if (findAccount(num) == null) {
			customer.setAccount_num(num);
		} else {
			System.out.println("이미 등록된 계좌입니다.");
			return;
		}

		System.out.print("계좌주 : ");
		customer.setAccount_holder(sc.next());
		System.out.print("초기입금액 : ");
		customer.setBalance(sc.nextInt());

		accountList.add(customer);
		System.out.println("계좌가 생성되었습니다.");
	}

	// 계좌목록출력
	public void accountList() {
		System.out.println("-----------------");
		System.out.println("계좌목록");
		System.out.println("-----------------");
		for (int i = 0; i < accountList.size(); i++) {
			System.out.print(accountList.get(i).getAccount_num() + "\t");
			System.out.print(accountList.get(i).getAccount_holder() + "\t");
			System.out.print(accountList.get(i).getBalance() + "\n");
		}
	}

	// 예금하기
	public void deposit() {
		System.out.println("-----------------");
		System.out.println("예금");
		System.out.println("-----------------");

		System.out.print("계좌번호 : ");
		Scanner sc = new Scanner(System.in);
		String num = sc.next();

		// 계좌번호 입력 유효성 체크
		try {
			Integer.parseInt(num);
		} catch (Exception e) {
			System.out.println("숫자를 입력해주세요");
			return;
		}

		// 입력한 계좌번호를 보유한 Account 찾기
		Account client = findAccount(num);
		
		// 입금
		if (client != null) {
			System.out.print("입금액 : ");
			int in = sc.nextInt();
			client.setBalance(client.getBalance() + in);
		} else {
			System.out.println("계좌번호를 잘못 입력하셨습니다.");
		}
	}

	// 출금하기
	public void withdraw() {
		System.out.println("-----------------");
		System.out.println("출금");
		System.out.println("-----------------");

		System.out.print("계좌번호 : ");
		Scanner sc = new Scanner(System.in);
		String num = sc.next();

		// 계좌번호 입력 유효성 체크
		try {
			Integer.parseInt(num);
		} catch (Exception e) {
			System.out.println("숫자를 입력해주세요");
			return;
		}

		// 계좌번호가 등록되어있는지 확인 후 진행
		Account client = findAccount(num);
		if (client != null) {
			System.out.print("출금액 : ");
			int out = sc.nextInt();

			// 계좌 잔고가 부족하지는 않은지 확인
			if (out > client.getBalance()) {
				System.out.println("에러 : 계좌 잔액이 부족합니다.");
			} else {
				// 잔고가 여유 있다면 출금 진행
				client.setBalance(client.getBalance() - out);
				System.out.println("결과 : 출금이 성공되었습니다.");
				System.out.println("계좌 잔액 : " + client.getBalance() + "원");
			}
		} else {
			// 등록되지 않은 계좌번호일 경우
			System.out.println("계좌번호를 잘못 입력하셨습니다.");
		}
	}

	// 매개변수(계좌번호)와 동일한 Account 객체 찾기
	private Account findAccount(String ano) {
		Account client = null;
		for (int i = 0; i < accountList.size(); i++) {
			if (ano.equals(accountList.get(i).getAccount_num())) {
				client = accountList.get(i);
				break;
			}
		}
		return client;
	}
}