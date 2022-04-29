package cloud;

public class Bacteria {
	public static void main(String[] args) {
		// 배열 생성
		int[] bacteriaCountLogs = new int[10];
		
		// 개체 수 기록
		writeLog(bacteriaCountLogs);
		
		// 결과 출력
		printLog(bacteriaCountLogs);
	}
	
	// 박테리아의 개체 수를 기록
	public static void writeLog(int[] arr) {
		// 메소드 완성
		int v = 1;
		for(int i=0; i<arr.length; i++) {
			arr[i] = v;
			v *= 2;
		}
		
//		for(int i=0; i<arr.length; i++) {
//			arr[i] = (int)Math.pow(2, i);
//		}
		
	}
	
	public static void printLog(int[] arr) {
		System.out.printf("[");
		for (int i=0; i<arr.length; i++) {
			System.out.printf("%d", arr[i]);
			if (i != arr.length-1) {
				System.out.printf(", ");
			}
		}
		System.out.printf("]");
	}
	
	
	
	
}
