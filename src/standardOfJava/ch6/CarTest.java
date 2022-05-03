package standardOfJava.ch6;
// 6.5.3_매개변수가 있는 생성자

class Car {
	String color;
	String gearType;
	int door;
	
	Car() {}
	
	Car(String c, String g, int d) {
		color = c;		// 색상
		gearType = g;	// 변속기 종류 - auto (자동), manual (수동)
		door = d;		// 문의 개수
	}
}
public class CarTest {

	public static void main(String[] args) {
		
		Car c1 = new Car();
		c1.color = "white";
		c1.gearType = "auto";
		c1.door = 4;
		
		Car c2 = new Car("white", "auto", 4);
		
		System.out.println("c1의 color=" + c1.color + ", c1.gearType=" + c1.gearType + ", c1.door=" + c1.door);
		System.out.println("c2의 color=" + c2.color + ", c2.gearType=" + c2.gearType + ", c2.door=" + c2.door);
		
		
	}

}
