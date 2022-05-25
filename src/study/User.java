package study;

public class User {

/*
필드 : 번호(no), 아이디(id), 비밀번호(pwd), 이름(name) -> private
메서드 
 - 모든 필드의 getter / setter
 - 로그인 메서드
   - ( 아이디 : admin, 비밀번호 : 1234 ) 이면 true, 아니면 false를 리턴 
	


 */
	private int no;
	private String id;
	private String pwd;
	private String name;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	// 로그인 메서드
//	접근제한자 리턴타입 메서드명(매개변수타입 매개변수명) 
	public boolean login(String id, String pwd) {
		boolean result = false;
//		if (id.equals("admin") && pwd.equals("1234")) {
//			result = true;
//		} 
		result = id.equals("admin") && pwd.equals("1234") ? true : false;
		
		return result;
	}
	
	
}
