package chapter05;

public class ArrayEx {

	public static void main(String[] args) {
		/*
		 배열 (Array)
		 배 -> 분배
		 열 -> 나열
		 
		 하나의 변수에 여러 값을 담을 때 사용
		 - 처음에 길이가 정해지면 변경 불가
		 - 모든 값이 동일한 자료형이어야 함
		 - 순번(index) : 0번부터 시작
		 		 
		 */
		
		// 선언
		// 정수타입 배열
		int a;
		a = 10;
		int[] a2;			// 배열 선언
		a2 = new int[5]; 	// 5개의 자리를 갖는 배열 초기화
		// {0, 0, 0, 0, 0}
		//  0, 1, 2, 3, 4  <----- 인덱스
		
		int[] a3 = {0, 0, 0};	// 3개의 자리 {0, 0, 0}으로 초기화! (선언과 초기화 동시!)
		
		// 배열의 길이 (값의 개수)
		System.out.println(a2.length);
		System.out.println(a3.length);
		
		// 배열의 접근
		// 변수[인덱스]
		System.out.println(a2[0]);
		
		// 값을 변경
		// 첫번째 자리 (0번 인덱스)에 1을 저장
		a2[0] = 1;
		System.out.println(a2[0]);

		a2[4] = 5;
		System.out.println(a2[4]);
		// 다른 타입의 자료형은 추가할 수 없다.
		// a2[1] = "홍길동"; 	 
		// a2[1] = 3.14;
		// a2[5] = 1;	// 인덱스 범위를 벗어나서 오류가 남

		// 마지막 인덱스 = 변수.length -1
		a2[a2.length-1] = 10;
		System.out.println(a2[4]);
		
		// 문자열 배열
		String[] name = new String[3];		// { null, null, null }
		// 김길동, 홍길동, 최길동
		name[0] = "김길동";
		name[1] = "홍길동";
		name[2] = "최길동";
		// { "김길동", "홍길동", "최길동" }
		
		// name 변수에 있는 모든 값을 출력
		for(int i=0; i<name.length; i++) {
			System.out.println(name[i]);
		}
		
	}

}
