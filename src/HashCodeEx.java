
public class HashCodeEx {

	public static void main(String[] args) {
		
		String str1 = new String("abc");
		String str2 = new String("abc");
		
		// String.hashCode() : 문자열이 같으면 동일한 hashcode를 리턴함
		System.out.println("str1.hashCode() : " + str1.hashCode());
		System.out.println("str2.hashCode() : " + str2.hashCode());
		
		// System.identityHashCode() : 객체의 주소값으로 해쉬코드를 생성함
		System.out.println("System.identityHashCode(str1) : " + System.identityHashCode(str1));
		System.out.println("System.identityHashCode(str2) : " + System.identityHashCode(str2));
	}

}
