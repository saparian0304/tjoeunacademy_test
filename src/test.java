public class test {

	public static void main(String[] args) {
		/*
		 알파벳 대소문자로 된 단어가 주어지면, 
		 이 단어에서 가장 많이 사용된 알파벳이 
		 무엇인지 알아내는 프로그램을 작성하시오. 
		 단, 대문자와 소문자를 구분하지 않는다.
		입력
		 첫째 줄에 알파벳 대소문자로 이루어진 단어가 주어진다. 
		 주어지는 단어의 길이는 1,000,000을 넘지 않는다.
		출력
		 첫째 줄에 이 단어에서 가장 많이 사용된 알파벳을 대문자로 출력한다. 
		 단, 가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 ?를 출력한다.

		 Mississipi -> ?
		 baaa -> A
		 zZa -> Z
		 z -> Z
		 
		 */
		// 입력 문자를 대문자로 바꾸기
		String str = "Mississipi";
		str=str.toUpperCase();
		System.out.println(str);
		// 가장 많이 사용된 알파벳을 찾는다 
		int[] arr = new int[str.length()];
		for (int i=0; i<arr.length; i++) {
			arr[i] = str.charAt(i);
			System.out.println(arr[i]);
		}
			
			// 문자가 같으면 인덱스에 +1
			// 같지않으면 다음 인덱스로 넘어감
			
		}
		
		
		
}

