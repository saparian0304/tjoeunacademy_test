package chapter05;

public class Excer5 {

	public static void main(String[] args) {
		// 이중 for문 사용해서 똑같이 출력하기
		for (int i=0; i<5; i++) {
			for (int j=5; j>i; j--) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}
