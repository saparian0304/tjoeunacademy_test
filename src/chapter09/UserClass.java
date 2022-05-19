package chapter09;

public class UserClass {

//	@UserAnnot (value="A")
	@UserAnnot ("A")	// value라는 속성은 생략이 가능하다 -> 생략한 경우 그 속성은 value이다.
	public void methodA() {
		System.out.println("MethodA() 실행");
	}
	
	@UserAnnot (value="B", number=10)
	public void methodB() {
		System.out.println("MethodB() 실행");
	}
}
