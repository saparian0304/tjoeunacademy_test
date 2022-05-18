package chapter08;

public class SmartPhoneMain {

	public static void main(String[] args) {
		
		Phone p = new Phone();
		p.name = "전화기";
		p.company = "현대";
		p.color = "화이트";
		
		System.out.println("Phone 출력");
		System.out.println(p.name);
		System.out.println(p.company);
		System.out.println(p.color);
		p.call();
		p.receive();
		
		SmartPhone sp = new SmartPhone();
		// 부모클래스의 멤버
		sp.name = "갤럭시";
		sp.company = "삼성";
		sp.color = "블랙";
		
		System.out.println("SmartPhone 출력");
		// 부모클래스의 멤버
		System.out.println(sp.name);		
		System.out.println(sp.company);
		System.out.println(sp.color);
		sp.call();
		sp.receive();
		// 자식클래스에 정의된 메서드
		sp.installApp();		

		// 부모클래스로 형변환 -> 자동형변환
		Phone sp1 = new SmartPhone();
//		sp1.installApp();		// 자식클래스에 정의된 멤버 사용 불가
		
		// 자식클래스로 형변환 -> 강제 형변환
		SmartPhone sp2 = (SmartPhone)p;
//		p.installApp();		// 자식클래스에 정의된 멤버 사용 불가
	}
	
}
