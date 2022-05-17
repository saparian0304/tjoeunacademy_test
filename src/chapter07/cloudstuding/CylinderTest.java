package chapter07.cloudstuding;

public class CylinderTest {

	public static void main(String[] args) {
		// 객체 생성
		Cylinder c = new Cylinder();
		
		// 속성 값 입력
		c.radius = 4;
		c.height = 5;
		
		// 출력
		System.out.printf("원기둥의 부피 : %.2f\n", c.getVolume());
		System.out.printf("원기둥의 겉넓이 : %.2f\n", c.getArea());

		Cylinder c2 = new Cylinder();
		c2.radius = 3;
		c2.height = 10;
		System.out.printf("원기둥의 부피 : %.2f\n", c2.getVolume());
		System.out.printf("원기둥의 겉넓이 : %.2f\n", c2.getArea());
	}

}

class Cylinder {
	/* 필드와 메소드를 구현하시오. */
	int radius;
	int height;
	
	double getVolume() {
		return Math.PI*radius * radius * height;
	}
	
	double getArea() {
		// 옆면 넓이 
		double midArea = 2 * Math.PI * radius * height;
		// 윗면, 아랫면 넓이
		double topArea =  2* Math.PI * radius * radius;
		return midArea + topArea;
	}
}
