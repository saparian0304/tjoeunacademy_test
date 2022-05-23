package chapter13.cloudStuding;

import java.util.ArrayList;

public class TotalSales2 {

	public static void main(String[] args) {

		// 구매할 tool 객체 생성
		Tool t1 = new Tool("망치", 5000, 1);
		Tool t2 = new Tool("드릴", 35000, 1);
		Tool t3 = new Tool("빗자루", 3000, 5);
		
		// 카트에 담기
		Cart2 myCart = new Cart2();
		
		myCart.add(t1);
		myCart.add(t2);
		myCart.add(t3);
		
		// 합계 구하기
		System.out.println(myCart.sumPrice());
		
	}

}

class Cart2 {
	private ArrayList<Tool> list;
	
	Cart2() {
		this.list = new ArrayList<Tool>();
	}
	
	public void add(Tool t) {
		list.add(t);
	}
	
	public int sumPrice() {
		int sum = 0;
		for (int i=0; i<list.size(); i++) {
			sum += list.get(i).getPrice() * list.get(i).getCnt();
		}
		return sum;
	}
	
}

class Tool {
	private String name;
	private int price;
	private int cnt;
	
	Tool(String name, int price, int cnt) {
		this.name = name;
		this.price = price;
		this.cnt = cnt;
	}
	
	public int getPrice() {
		return price;
	}
	
	public int getCnt() {
		return cnt;
	}
}
