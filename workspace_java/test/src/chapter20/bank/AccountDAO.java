package chapter20.bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import chapter20.MemberVO;

public class AccountDAO {
	private List<AccountVO> accountList = new ArrayList<AccountVO>();

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public AccountDAO() {

		try {
			// 드라이버 로드
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb", "root", "root1234");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	// 계좌생성 메서드
	public void createAccount() {
		entry("계좌생성");
		// 계좌를 생성할 Account 객체 생성
		AccountVO customer = new AccountVO();
		Scanner sc = new Scanner(System.in);
		// 새로 만들 계좌 정보 입력
		System.out.print("계좌번호 : ");
		String num = sc.next();

		// 계좌번호 입력 유효성 체크
		if (!checkNum(num))
			return; // false를 반환하면 메서드 종료
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
		if (execute(customer) > 0) {
			System.out.println("계좌가 생성되었습니다.");
		}
	}

	// 예금하기
	public void deposit() {
		entry("예금");

		System.out.print("계좌번호 : ");
		Scanner sc = new Scanner(System.in);
		String num = sc.next();

		// 계좌번호 입력 유효성 체크
		if (!checkNum(num))
			return; // false를 반환하면 메서드 종료
		// 입력한 계좌번호를 보유한 Account 찾기
		AccountVO client = findAccount(num);

		// 입금
		if (client != null) {
			System.out.print("입금액 : ");
			try {
			int in = sc.nextInt();
			client.setBalance(client.getBalance() + in);
			} catch (Exception e) {
				System.out.println("숫자를 입력하세요");
				return;
			}
			if (update(client) > 0) {
				System.out.println("입금 완료.");
			}
		} else {
			System.out.println("계좌번호를 잘못 입력하셨습니다.");
		}
	}

	// 출금하기
		public void withdraw() {
			entry("출금");

			System.out.print("계좌번호 : ");
			Scanner sc = new Scanner(System.in);
			String num = sc.next();

			// 계좌번호 입력 유효성 체크
			if(!checkNum(num))	return;	// false를 반환하면 메서드 종료

			// 계좌번호가 등록되어있는지 확인 후 진행
			AccountVO client = findAccount(num);
			if (client != null) {
				System.out.print("출금액 : ");
				int out = sc.nextInt();

				// 계좌 잔고가 부족하지는 않은지 확인
				if (out > client.getBalance()) {
					System.out.println("에러 : 계좌 잔액이 부족합니다.");
				} else {
					// 잔고가 여유 있다면 출금 진행
					client.setBalance(client.getBalance() - out);
					if (update(client) > 0) {
						System.out.println("결과 : 출금이 성공되었습니다.");
					}
					System.out.println("계좌 잔액 : " + client.getBalance() + "원");
				}
			} else {
				// 등록되지 않은 계좌번호일 경우
				System.out.println("계좌번호를 잘못 입력하셨습니다.");
			}
		}
	
	// 계좌목록출력
	public void accountList() {
		accountList = list();
		entry("계좌목록");
		for (int i = 0; i < accountList.size(); i++) {
			System.out.print(accountList.get(i).getAccount_num() + "\t");
			System.out.print(accountList.get(i).getAccount_holder() + "\t");
			System.out.print(accountList.get(i).getBalance() + "\n");
		}
	}

	// DB에 입력
	public int execute(AccountVO vo) {
		int result = 0;
		try {
			String sql = "INSERT INTO account (accountno, name, balance) VALUES (?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getAccount_num());
			pstmt.setString(2, vo.getAccount_holder());
			pstmt.setInt(3, vo.getBalance());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	// DB에 수정
		public int update(AccountVO vo) {
			int result = 0;
			try {
				String sql = "UPDATE account SET balance=? WHERE accountno=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, vo.getBalance());
				pstmt.setString(2, vo.getAccount_num());
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			return result;
		}
	
	// 회원 목록
	public List<AccountVO> list() {
		accountList = new ArrayList<AccountVO>();

		try {
			String sql = "SELECT * FROM account";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				AccountVO vo = new AccountVO();
				vo.setAccount_num(rs.getString("accountno"));
				vo.setAccount_holder(rs.getString("name"));
				vo.setBalance(rs.getInt("balance"));
				accountList.add(vo);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return accountList;
	}

	// 매개변수(계좌번호)와 동일한 Account 객체 찾기
	private AccountVO findAccount(String ano) {
		AccountVO client = null;
		accountList = list();
		for (int i = 0; i < accountList.size(); i++) {
			if (ano.equals(accountList.get(i).getAccount_num())) {
				client = accountList.get(i);
				break;
			}
		}
		return client;
	}

	/**
	 * 계좌번호가 숫자인지 문자인지 확인하는 메서드
	 * 
	 * @param num 계좌번호
	 * @return 계좌번호가 숫자가 아닌경우 false 반환
	 */
	private boolean checkNum(String num) {
		boolean flag = true;
		try {
			Integer.parseInt(num);
		} catch (Exception e) {
			System.out.println("숫자를 입력해주세요");
			flag = false;
		}
		return flag;
	}

	// 자원 close()
	public void close() {
		if (conn != null) {
			try {	conn.close();	} catch (SQLException e) {		}
		}
		if (pstmt != null) {
			try {	pstmt.close();	} catch (SQLException e) {	}
		}
	}
	
	public void entry(String str) {
		System.out.println("-----------------");
		System.out.println(str);
		System.out.println("-----------------");
	}
}
