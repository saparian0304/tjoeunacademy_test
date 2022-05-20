package chapter13.practice;

public class Rectangle extends Shape {
	double w;
	double h;
	
	Rectangle() {
		this(1, 1);
	}
	
	Rectangle(double w, double h) {
		this.w = w;
		this.h = h;
	}
	
	public double area() {
		return w * h;
	}

	public double length() {
		return (w + h) * 2;
	}
}
