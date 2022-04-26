package chapter04;

public class OpEx5_1 {
	// 책에 없는 예제
	public static void main(String[] args) {
		String id=null;	// false 		db에서 가져올수도, 값이 없을수도 있음
//		String id="admin";	// true
//		String id="user";	// false
		
		// 아이디가 admin이면 성공
		// 아이디가 null이면(false), 뒤에 항은 확인을 안함 => 숏컷(shortcut)
		System.out.println(id != null && id.equals("admin"));
				
	}

}
