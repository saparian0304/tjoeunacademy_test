package chapter09;

public interface GraphicCard {
	
	String MEMORY = "2G";
	public void process();
	
	default void dfTest() {
		System.out.println("GraphicCard 인터페이스 내 default 메서드");
	}
}
