package chapter05;

// 반복문의 중지 - break : 반복문을 빠져나옴
public class BreakEx {

	public static void main(String[] args) {
		
		for(int i=0; i<10; i++) {
			if ( i==5 ) {
				break;
			}
			System.out.println(i);
		}
		
	}

}
