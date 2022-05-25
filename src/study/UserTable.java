package study;

import java.awt.desktop.UserSessionListener;
import java.util.ArrayList;
import java.util.List;

public class UserTable {
	List<User> userList;
	int no; 	// 자동 증가할 번호
	
	// 생성자(초기화)
	UserTable() {
		userList = new ArrayList<User>();
		no = 1;
	}
	// 아이디, 비밀번호, 이름 입력받아서 user 객체에 담아서 리턴
	
	public User getUser(int no, String id, String pwd, String name) {
		
		User u = new User();		// User 객체 생성 -> 매개변수 정보를 담을 객체
		u.setId(id);				// 생성한 객체에 id 정보 담기
		u.setPwd(pwd);				// 생성한 객체에 pwd 정보 담기
		u.setName(name);			// 생성한 객체에 name 정보 담기
		u.setNo(no);
		return u;			// 정보를 담은 User 객체 반환
	}
	
	public static void main(String[] args) {
		
		UserTable ut = new UserTable();		// UserTable 생성
		
//		User x = ut.getUser("hong", "1234", "홍길동");	// User 객체를 UserTable객체에 담기
		// getUser("a", "b", "c") -> User 객체에 a,b,c 정보를 담아서 user를 반환하는 메서드
		
//		System.out.println(x.getId());		// User 객체 x에 담긴 id 정보 출력
//		System.out.println(x.getPwd());		// User 객체 x에 담긴 pwd 정보 출력
//		System.out.println(x.getName());	// User 객체 x에 담긴 name 정보 출력
		
		// insert() 메서드가 잘 되는지 확인
		System.out.println(ut.insert("hong", "1234", "홍길동"));	// true
		System.out.println(ut.insert("kim", "2345", "김길동"));		// true
		System.out.println(ut.insert("hong", "1234", "홍길동"));	// false가 나와야함
		
		if (ut.insert("hong", "1234", "홍길동")) {
			System.out.println("회원가입 성공");
		} else {
			System.out.println("아이디가 중복되었습니다.");
		}
		
		// insert() 후 userList에 담긴 정보 확인하기 ( userList <- UserTable 객체에 담긴 ArrayList)
		for (int i=0; i<ut.userList.size(); i++) {
			System.out.println(ut.userList.get(i).getName());
		}

		System.out.println(ut.findUser("hong").getNo()+""+ut.findUser("hong").getId());
		
		// update 메서드 확인
		ut.update("kim", "김길똥", "1111");
		for (int i=0; i<ut.userList.size(); i++) {
			System.out.println(ut.userList.get(i).getName());
		}
	}
	/*
	   아이디, 비밀번호, 이름 입력받아서 
	   getUser 메서드를 호출, 객체를 리턴받아 변수에 저장
	   현재 list에서 아이디가 존재하는지 여부 체크
	   존재하면 false 리턴, 
	   존재하지 않으면 list에 추가하고 true를 리턴
	   
	   수정 : findUser 메서드 활용
	   수정 : no를 1씩 증가되도록
	 */
	public boolean insert (String id, String pwd, String name) {
		// 아이디 중복 여부 체크
		if (findUser(id) != null) return false;
		return userList.add(getUser(no++, id, pwd, name));
	}
	
	/*
	 * 아이디를 입력받아 리스트에 해당 아이디의 객체를 리턴
	 * 존재하지 않으면 null을 리턴
	 */
	
	public User findUser(String id) {
		// 리스트가 가진 객체들을 체크하기 위한 반복문 
		for (int i=0; i<userList.size(); i++) {
			// 리스트에 해당 아이디를 가진 객체가 있는지 확인
			if (id.equals(userList.get(i).getId())) {		
				return userList.get(i);		// 존재하는 경우 그 객체를 리턴
			}
		}
		return null;		// 없는 경우 null을 리턴
	}
	
	/*
	 * PK(id)로 이름, 비밀번호 변경
	 */
	public boolean update(String id, String name, String pwd) {
		User u = findUser(id);
		if (u != null) {
			u.setName(name);
			u.setPwd(pwd);
			return true;
		}
		return false;
	}
	
	
}
