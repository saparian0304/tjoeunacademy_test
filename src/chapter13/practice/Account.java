package chapter13.practice;

public class Account {
	// 계좌번호, 계좌주, 잔액 필드 생성
	private String account_num;		// 계좌번호
	private String account_holder;	// 계좌주인
	private int balance;			// 계좌 잔고
	
	// getter / setter 메서드 생성
	public String getAccount_num() {
		return account_num;
	}
	public void setAccount_num(String account_num) {
		this.account_num = account_num;
	}
	public String getAccount_holder() {
		return account_holder;
	}
	public void setAccount_holder(String account_holder) {
		this.account_holder = account_holder;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}


}