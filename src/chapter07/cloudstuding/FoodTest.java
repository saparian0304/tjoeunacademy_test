package chapter07.cloudstuding;

public class FoodTest {

	public static void main(String[] args) {
		
		// 음식 객체 생성
		Food chicken = new Food("치킨", 18000);
		Food pizza = new Food("피자", 28000);
		Food sushi = new Food("초밥세트", 22000);
		
		// 객체 배열에 음식 담기
		Food[] foods = {chicken, pizza, sushi};
		
		// 모든 음식 정보 출력
		for (int i=0; i<foods.length; i++) {
			System.out.println(foods[i].toString());
		}
		Food a = new Food();
		a.name = "d";
		a.price = 1;
		
		Food b = new Food();
		b.name = "d";
		b.price = 1;
		
		Food c = new Food("ddd", 300); 
		
	}
}

class Food {
	// 1. 필드 추가
	public String name;
	public int price;
	// 2. 생성자 추가
	Food() {}
	
	Food(String name, int price) { 
		this.name = name;
		this.price = price;
	}
	// 3. toString() 메소드 추가
	// toString()은 상속받은 메서드이기 때문에 
	// 부모의 접근제어자보다 좁은 범위의 접근제어자를 사용할 수 없다.
	public String toString() {	
		return "Food { name: " + name + ", price: " + price + "원 }";
	}
	
}