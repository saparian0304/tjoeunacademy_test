package chapter07;

public class Member {
	String name;
	void login() { }

	public static void main(String[] args) {
		// Gladiator 클래스는 Warrior 클래스를 상속받음
		Gladiator g = new Gladiator();
		
		// 자기 클래스의 메서드 사용 가능
//		g.specialAttack();
		
		// 부모클래스(Warrior)의 멤버도 사용이 가능함 ( 변수 hp, 메서드 attack())
		g.hp = 30;
		g.attack();
		
	}
	
}
