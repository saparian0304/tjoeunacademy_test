package chapter07;

public class SingletonMain {

	public static void main(String[] args) {
		
//		 Singleton s = new Singleton(); 	// 에러 발생
		
		// static 변수이기때문에 객체 생성은 클래스가 로드될 때 한번만 수행됨
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();		 
		Singleton s3 = Singleton.getInstance();
		
	}
}
