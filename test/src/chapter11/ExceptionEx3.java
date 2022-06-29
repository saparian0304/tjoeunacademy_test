package chapter11;

public class ExceptionEx3 {

	public static void main(String[] args) {
		
		try {
			int[] arr = {1,2,3};
//			System.out.println(arr[3]);
//			System.out.println(3/0);
//			Integer.parseInt("a");
			return;
//		} catch (ArithmeticException e){
//			System.out.println("0으로 나눌 수 없음");
//		} catch (ArrayIndexOutOfBoundsException e) {
//			System.out.println("인덱스 범위 초과");
		} catch (Exception e) {					// 실제 업무시에는 이렇게만 써도 된다.
			System.out.println("예외 발생");	// 프로그램이 중단되지 않도록 하는 것이 중요함
			System.out.println(e.getMessage());		// 에러 이유 출력
			e.printStackTrace();					// 예외 설명 출력
		} finally {
			System.out.println("무조건 실행되는 finally 구문");		// 오류시 네크워크 연결을 끊을 수 있게 해줌
			// 메서드가 return문으로 인해 위에서 종료되더라도 실행됨 
		}
		
		System.out.println("try-catch구문 밖에서 실행되는 메서드");	
		
	}

}
