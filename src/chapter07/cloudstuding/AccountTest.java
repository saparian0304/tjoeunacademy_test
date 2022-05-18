package chapter07.cloudstuding;

public class AccountTest {
	public static void main(String[] args) {
		// 객체 생성
		Account a = new Account("123-45", 10000);
		Account b = new Account("567-89", 10000);
		
		// 송금 : 3천원씩 a계좌에서 -> b계좌로!
		boolean result = true;
		while (result) {
			result = a.transfer(b, 3000);
		}
		
		// 결과 출력
		System.out.println(a.toString());
		System.out.println(b.toString());
	}
}
class Account {
	/**
	 * @param num 계좌번호
	 */
	String num; 	// 계좌번호
	int balance;	// 잔액
	
	public Account(String str, int i) {
		num = str;
		balance = i;
	}
	
	public String toString() {
		return String.format("Account { num:%s, balance:%d }", num, balance);
	}
	/**
	 * 해당 객체의 잔액을 확인
	 * 잔액이 amount보다 크면 
	 * 		잔액 차감, 대상(target)의 잔액 추가
	 * @param target 입금할 대상
	 * @param amount 입금액
	 * @return 계좌이체 성공:true, 실패:false
	 */
	public boolean transfer(Account target, int amount) {
		if (balance < amount) {
			return false;
		}
		
		// 현재 잔액에서 송금액을 이체대상 계좌로 전달
		target.balance += amount;
		balance -= amount;
		return true;
	}
}
