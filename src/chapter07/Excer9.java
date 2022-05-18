package chapter07;

public class Excer9 {

	public static void main(String[] args) {
		Excercise ex1 = Excercise.getInstance();
		Excercise ex2 = Excercise.getInstance();
		
		System.out.println("ex1 == ex2 : " + (ex1 == ex2));
		
	}
}

class Excercise {
	private static Excercise instance = new Excercise();

	private Excercise() {}
		
	public static Excercise getInstance() {
		return instance;
	}
	
}