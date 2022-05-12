public class Main {

	public static void main(String[] args) {
		// 생성자가 없는 숫자
		// 셀프넘버를 판별하는 함수를 만들어라...
		for (int i=1; i<10000; i++) {
			if (selfNum(i))
			System.out.println(i);
		}
			
	}
	
	// 메서드 생성 : true이면 셀프넘버
	public static boolean selfNum(int i) {
		boolean result = true;
		
		
		for (int j=1; j <= i-1; j++) {
		// 가능한 범위의 반복문으로 수 출력
			// 각 자리수 확인
			int iCnt = 0;
			int iNum =j;
			while (true) {
				iCnt ++;
				if (iNum/10 == 0)
					break;
				iNum /= 10;
			}
			// 각 자리수 합치기
			int sum = 0;
			iNum = j;
			for (int k=0; k<iCnt; k++) {
				sum += iNum%10;
				iNum /= 10;			
			}
//			System.out.println(sum);
			if ( i == j+sum) {
				result = false;
//				System.out.println(i);
			}
		}
		return result;
	}
}

