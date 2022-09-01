package chapter20;

public class MemberVO {

	// 외부에서 직접 접근을 못하도록 private로 필드를 구성
	
	private int memberno; 	// 회원번호
	private String id;		// 아이디 
	private String name;	// 이름
	
	// getter, setter 만들기 -> alt + shift + s -> r -> alt + a -> r 
	public int getMemberno() {
		return memberno;
	}
	public void setMemberno(int memberno) {
		this.memberno = memberno;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
