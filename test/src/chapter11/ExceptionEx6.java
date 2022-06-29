package chapter11;

public class ExceptionEx6 {

	public static void main(String[] args) {
		
		try {
			first();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		// 이렇게 처리하는 경우도 있음 : 컴파일 에러만 피하고 예외처리는 X 
		try { first(); } catch (Exception e) { }
		try { first(); } catch (Exception e) { }
		try { first(); } catch (Exception e) { }
		
	}
	static void test() throws ClassNotFoundException {
		Class.forName("chapter11.ExceptionEx6");
	}
	
	static void first() throws Exception {		// throws : 예외 떠넘기기
		second();
	}
	static void second() throws Exception {		// throws : 예외 떠넘기기
		throw new Exception("예외 발생");		// throw : 예외 발생시키기
	}

}
