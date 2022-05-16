package chapter06;

public class ReferenceType {

	public static void main(String[] args) {
		
		String name1 = "홍길동";
		String name2 = "홍길동";
		
		System.out.println(name1 == name2);	// true
		
		String name3 = new String("홍길동");
		String name4 = new String("홍길동");
		
		System.out.println(name3);
		System.out.println(name4);
		System.out.println(name3 == name4);	// false : 주소값을 비교
		System.out.println(name3.equals(name4));	// equals():문자열 값을 비교
		
		// *참조자료형을 '=='로 비교할 경우 주소를 비교함 (값을 비교하지 않음)
		int[] a = {1};
		int[] b = {1};
		System.out.println(a==b);
	}

}
