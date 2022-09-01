package chapter06;

public class ArrEx17 {

	public static void main(String[] args) {
		
		// 배열선언
		String[] names = {"홍길동", "이순신", "김유신"};
		int[] scores = {90, 80, 100};
		
		int i=0;	// 인덱스 변수
		for (String name : names) {		// 향상된 for문
			System.out.println(name + " : " + scores[i]);
			i++;
		}
		
		for (int j=0; j<names.length; j++) {
			System.out.println(names[j] + " " + scores[j]);
		}
		
	}

}
