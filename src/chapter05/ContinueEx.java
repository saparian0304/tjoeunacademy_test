package chapter05;

// 반복문의 중지 - continue : 다음 반복으로 넘어감
public class ContinueEx {

	public static void main(String[] args) {
		
		for (int i=0; i<10; i++) {
			if (i==5) {
				continue;
			}
			System.out.println(i);
		}
		
		
		// 반복문 -> 중첩
		
		abc :	// 반복문의 이름 부여
		for (int j=2; j<=9; j++) {			// 단 반복
			System.out.println("[" + j + "단]");
			for (int i=1; i<=9; i++) {		// 곱수 반복
				System.out.println(j + " * " + i + " = " + j*i);	
				if ( i==6 ) {
					break abc;	// 해당 이름의 반복문 중지
				}
			}		
		}
		
	}

}
