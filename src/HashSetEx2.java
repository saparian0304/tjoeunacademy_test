import java.util.HashSet;
import java.util.Set;

public class HashSetEx2 {

	public static void main(String[] args) {

		// HashSet 객체 생성
		Set set = new HashSet();
		
		// 문자열 객체 두개 추가
		set.add(new String("abc"));
		set.add(new String("abc"));
		
		// Member 객체 두개 추가 (사용자 정의 클래스)
		set.add(new Member("홍길동", 40));
		set.add(new Member("임꺽정", 40));
		
		// 출력
		System.out.println(set);
	}

}


class Member {
	// 필드
	String name;
	int age;
	
	// 생성자
	Member(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	// toString() 메서드 재정의
	@Override
	public String toString() {
		return "(" + name + ", " + age + ")";
	}
	
	// equals() 메서드 재정의
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Member) {
			Member m = (Member)obj;
			return this.name.equals(m.name)&& this.age == m.age; 
		} else {
			return false;
		}
	}
	// hashCode() 메서드 재정의
	@Override 
	public int hashCode() {
		return this.name.hashCode() + age;
	}
	
	
}