import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		/*
		 * 알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 
		 * 알아내는 프로그램을 작성하시오. 단, 대문자와 소문자를 구분하지 않는다. 
		 * 입력 첫째 줄에 알파벳 대소문자로 이루어진 단어가 주어진다. 
		 * 주어지는 단어의 길이는 1,000,000을 넘지않는다. 
		 * 출력 첫째 줄에 이 단어에서 가장 많이 사용된 알파벳을 대문자로 출력한다. 
		 * 단, 가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 ?를 출력한다.
		 * 
		 * Mississipi -> ? baaa -> A zZa -> Z z -> Z
		 * 
		 */
		// 입력 문자를 대문자로 바꾸기
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		str=str.toUpperCase();
		int[] arr = new int[26];
		for (int i = 0; i < str.length(); i++) {
			for (int j=0; j<arr.length; j++) {
				// 존재하면 +1
				if (str.charAt(i)-65 == j) {
					arr[j]++;
				} 
			}
		}
		
		// 최대값 찾기
		int max = arr[0];
		for(int i=0; i<arr.length; i++) {
			if (max < arr[i]) {
				max = arr[i];
			}
		}
		int cnt = 0;
		int strNum = 0;
		for (int i=0; i<arr.length; i++) {
			if(max==arr[i]) {
				cnt++;
				strNum = i;
			}
		}
		String result = cnt==1 ? (char)(strNum+65) + "": "?";
		System.out.println(result);
		
		
		// 같지않으면 다음 인덱스로 넘어감
	}
}

/*
 * M => I S S I S S I P I
 * 
 * 
 * 
 * 
 * 
 * 
 */
