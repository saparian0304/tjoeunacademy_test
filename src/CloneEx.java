
public class CloneEx {

	public static void main(String[] args) {
		String[] arr = {"홍길동", "이순신", "김유신", "안중근"};
		String[] arr2 = arr.clone();
		// clone() 메서드는 객체를 복제하기 위한 메서드다
		
		
		System.out.println(arr == arr2);
		for (String v : arr2) {
			System.out.println(v);
		}
		
		String[] arr3 = new String[arr.length];
		System.arraycopy(arr, 0, arr3, 0, arr.length);
		
		System.out.println(arr == arr3);
		for (String v : arr3) {
			System.out.println(v);
			
		// System.arraycopy() : 배열을 복사할때 사용하던 메서드
		// 배열을 복사할 때도 clone() 메서드를 이용할 수 있다.
			
		}
	}

}
