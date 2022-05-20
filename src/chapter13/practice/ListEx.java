package chapter13.practice;

import java.util.ArrayList;
import java.util.List;

public class ListEx {

	public static void main(String[] args) {
		
		List<Shape> list = new ArrayList<Shape>();
		
		list.add(new Circle(4));
		list.add(new Rectangle(3, 5));
		list.add(new Circle(1));
		list.add(new Rectangle(7, 13));
		
		System.out.println("전체 도형의 넓이는 : " + totalArea(list));
		System.out.println("전체 도형의 둘레는 : " + totalLength(list));
	}

	public static double totalArea(List<Shape> list) {
		double sum = 0;
		for (int i=0; i<list.size(); i++) {
			sum += list.get(i).area();
		}
		return sum;
	}
	public static double totalLength(List<Shape> list) {
		double sum = 0;
		for (int i=0; i<list.size(); i++) {
			sum += list.get(i).length();
		}
		return sum;
	}
	
}
