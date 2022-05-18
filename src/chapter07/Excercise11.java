package chapter07;

public class Excercise11 {

	public static void main(String[] args) {
		
		Math m = new Math();
		int[] arr = {9, 5, 24, 13, 3, 21};
		int max = m.max(arr);
		int min = m.min(arr);
		
		System.out.println("최대값 : " + max);
		System.out.println("최소값 : " + min);
		
	}
}

class Math {
	/**
	 * 최대값을 구하는 메서드
	 * @param arr 최대값을 구할 대상이 되는 배열
	 * @return 배열 중 최대값
	 */
	int max(int[] arr) {
		int max = arr[0];
		for (int i=0; i<arr.length; i++) {
			max = max >= arr[i] ? max : arr[i];
		}
		return max;
	}
	
	/**
	 * 최소값을 구하는 메서드
	 * @param arr 최소값을 구할 대상이 되는 배열
	 * @return 배열 중에 최소값
	 */
	int min(int[] arr) {
		int min = arr[0];
		for (int i=0; i<arr.length; i++) {
			min = min < arr[i] ? min : arr[i];
		}
		return min;
	}
}