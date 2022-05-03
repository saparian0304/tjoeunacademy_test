package standardOfJava.ch6;

// 6.5.2_기본 생성자
public class ConstructorTest {
	
	public static void main(String[] args) {
		Data1 d1 = new Data1();		// 에러 x ( class에 정의된 생성자가 없으므로 기본생성자 사용 가능)
//		Data2 d2 = new Data2();		// 컴파일 에러 발생 ( class에 생성자 Data2() 가 정의되어있지 않기 때문)
		Data2 d3 = new Data2(1);

	}

}

// 생성자가 정의되어 있지 않은 클래스
class Data1 { 
	int value;
}

// 생성자가 정의되어있는 클래스
class Data2 {
	int value;
	
	Data2(int x) {		// 매개변수가 있는 생성자
		value = x;
	}
}