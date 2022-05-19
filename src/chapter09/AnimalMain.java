package chapter09;

public class AnimalMain {

	public static void main(String[] args) {
		
		Animal eagle = new Eagle();
		
		eagle.sleep();
//		eagle.eat();	// 에러 : Animal 인터페이스에는 eat() 메서드가 없음
		
		Eagle eagleObj = (Eagle)eagle;	// 생성한 객체가 Eagle 객체라서 강제형변환이 가능 
		eagleObj.eat();
	}

}
