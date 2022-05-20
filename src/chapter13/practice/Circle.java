package chapter13.practice;

public class Circle extends Shape {

	Circle() {
		this(1);
	}
	
	Circle(double radius) {
		this.radius = radius;
	}
	
	double radius;
	
	public double area() {
		return radius * radius * Math.PI;
	}
	public double length() {
		return 2 * Math.PI * radius;
	}
}
