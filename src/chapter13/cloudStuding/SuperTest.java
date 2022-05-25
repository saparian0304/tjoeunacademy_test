package chapter13.cloudStuding;

public class SuperTest {
	public static void main(String[] args) {
		/* 1. Orc 객체를 만들고 정보를 출력하시오. */
		Orc orc = new Orc("dddd", 3);
		/* 2. OrcWarrior 객체를 만들고 정보를 출력하시오. */
	}
}

class Orc {
	protected String name;
	protected int hp;

	// 매개변수 2개짜리 생성자
	public Orc(String name, int hp) {
		this.name = name;
		this.hp = hp;
	}

	public String toString() {
		return String.format("Orc { name: %s, hp: %d }", this.name, this.hp);
	}
}

class OrcWarrior extends Orc {
	protected int amor;

	// 매개변수가 3개짜리 생성자
	public OrcWarrior(String name, int hp, int amor) {
		// 부모클래스에 기본생성자가 없으므로 다른 생성자 호출해줘야함
		super(name, hp);	
		this.amor = amor;
	}

	// 메소드 오버라이딩!
	public String toString() {
		return String.format("OrcWarrior { name: %s, hp: %d, amor: %d }", super.name, super.hp, this.amor);
	}
}