import java.util.*;

public class test {

	public static void main(String[] args) {
      
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		int[] word = new int[26];
		int len = str.length();
//		char a = 'a';	// 97
		for (int i=0; i<word.length; i++) {
			word[i] = -1;
		}
		for (int i=0; i<word.length; i++) {
			// 단어길이만큼의 반복문
			for (int j=0; j<len; j++) {
				if(word[str.charAt(j)-97] == -1 && str.charAt(j)-97== i) {
					word[str.charAt(j)-97] = j;
				} 
			}
		}
		for (int i=0; i<word.length; i++) {
			System.out.print(word[i] + " ");
		}
//		System.out.println(str.charAt(0)-96);
    }

}
