package study;

import java.util.Scanner;

public class UserMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		UserTable ut = new UserTable();
		
		boolean flag = true;
		while(flag) {
			System.out.println("1. 회원등록 | 2. 회원목록 | 3. 회원상세 | 4. 회원수정 | 5. 종료");
			System.out.print("입력:");
			int inputNumber = 0 ;
			try {
				inputNumber = scan.nextInt();
			} catch (Exception e) {
				scan.nextLine();
				System.out.println("1~5사이의 숫자를 입력하세요");
			}
			
			if (inputNumber == 1) {
				System.out.println("[회원등록]");
				System.out.print("아이디 : ");
				String id = scan.next();
				System.out.print("비밀번호 : ");
				String pwd = scan.next();
				System.out.print("이름 : ");
				String name = scan.next();
				
				if (ut.insert(id, pwd, name)) {
					System.out.println("회원등록 성공");
				} else {
					System.out.println("중복된 아이디입니다.");
				}
			} else if (inputNumber == 2) {
				System.out.println("[회원목록]");
				System.out.println("번호\t아이디\t비밀번호\t이름");
				
				if (ut.userList.size() ==0) {
					System.out.println("등록된 회원이 없습니다.");
				} else {
					for (int i=0; i<ut.userList.size(); i++) {
						User u = ut.userList.get(i);
						System.out.println(u.getNo() +
								"\t" + u.getId() +
								"\t" + u.getPwd() +
								"\t" + u.getName());
					}
				}
			} else if (inputNumber == 3) {
				System.out.println("[회원상세]");
				System.out.print("아이디 : ");
				String id = scan.next();
				User u = ut.findUser(id);
				if (u == null)
					System.out.println("해당 아이디가 존재하지 않습니다.");
				else {
					System.out.println("번호 : " + u.getNo());
					System.out.println("아이디 : " + u.getId());
					System.out.println("이름 : " + u.getName());
					System.out.println("비밀번호 : " + u.getPwd());
				}
			} else if (inputNumber == 4) {
				System.out.println("[회원수정]");
				System.out.print("아이디 : ");
				String id = scan.next();
				System.out.print("비밀번호 : ");
				String pwd = scan.next();
				System.out.print("이름 : ");
				String name = scan.next();
				if (ut.update(id, name, pwd)) {
					System.out.println("정상적으로 수정되었습니다.");
				} else {
					System.out.println("해당 아이디가 존재하지 않습니다.");
				}
			} else if (inputNumber == 5) {
				flag = false;
				System.out.println("종료");
			}
		
		}
		
		
		
	}
}
