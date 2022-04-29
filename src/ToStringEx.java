
public class ToStringEx {

	public static void main(String[] args) {
		Fruit f = new Fruit("사과", "빨강");
		System.out.println(f);
		
		Fruit f1 = new Fruit("사과", "빨강");
		System.out.println(f1);
	}

}


class Fruit {
	String name;
	String color;
	
	public Fruit(String name, String color) {
		this.name = name;
		this.color = color;
	}
}