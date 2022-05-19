package chapter08.cloudStuding;

public class InheritanceTest {
	public static void main(String[] args) {
		// 객체 생성
		Pet dog = new Pet();

		/* 4. 객체를 초기화하세요. */
		dog.name = "차우차우";
		dog.age = 3;
		dog.price = 2200000;

		// 정보 출력
		System.out.printf("Pet { name: %s, age: %d세, price: %d원 }", dog.name, dog.age, dog.price);
	}
}

class Animal {
	String name; // 이름

	public void cry() {
		System.out.println("동물이 웁니다!");
	}
}

/* 1. Pet 클래스를 Animal로부터 확장 선언 하세요. */
class Pet extends Animal {
	/* 2. 부모 클래스 Animal과 중복되는 필드를 제거하세요. */
	int age; // 나이
	int price; // 가격

	/* 3. 부모 클래스 Animal과 중복되는 메소드를 지우세요. */

	public void play() {
		System.out.println("애완 동물이 장난을 칩니다~");
	}
}
