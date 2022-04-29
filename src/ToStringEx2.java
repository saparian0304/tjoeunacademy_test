
public class ToStringEx2 {

	public static void main(String[] args) {
		Fruit2 f = new Fruit2("사과", "빨강");
		System.out.println(f);		
		// 콘솔에 객체를 직접 출력하는 경우 자동으로 toString() 메서드가 실행된다!
	}

}


class Fruit2 {
	String name;
	String color;
	public Fruit2(String name, String color) {
		this.name = name;
		this.color = color;
	}
	
	@Override
	public String toString() {
		return "과일 이름 : " + this.name + "\n과일 색상 : " + this.color;
	}
}