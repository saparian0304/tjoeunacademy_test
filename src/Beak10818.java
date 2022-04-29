import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Beak10818 {
	public static void main(String[] args) throws IOException {
		
/*
백준 10818번
최소값과 최댓값을 공백으로 구분해 출력한다
5
20 10 35 30 7
*/
		
		
		
///////////////
// 시간초과 ///
///////////////
/*
		Scanner sc = new Scanner(System.in);
		// 정수의 개수 입력
		int input = sc.nextInt();
		
//		 정수 입력해서 배열에 추가
		int[] arr = new int[input];
		for (int i=0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		
		// 반복횟수
		for (int i=1; i<arr.length; i++) {
			// 오른쪽과 비교 후 크면 순서 바꾸기
			for (int j=0; j<arr.length-i; j++) {
				int tmp;
				if (arr[j]>arr[j+1]) {
					tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;							
				}
					
			}
		}
		int min = arr[0];
		int max = arr[arr.length-1];
		
		System.out.println(min + " " + max);
*/
		
		
		Scanner sc = new Scanner(System.in);
        
        // 배열 숫자 입력
        int num = sc.nextInt();
        sc.nextLine();
        // 인수 입력
        String input = sc.nextLine();
        String[] arr = new String[num]; 
        arr = input.split(" ");
        
//        System.out.println(num + arr[0]);
        int min = Integer.parseInt(arr[0]);
        int max = Integer.parseInt(arr[0]);
        for (int i=0; i<num; i++) {
        	if (Integer.parseInt(arr[i]) > max)
        		max = Integer.parseInt(arr[i]);
        	if (Integer.parseInt(arr[i])< min)
        		min = Integer.parseInt(arr[i]);
        }
        System.out.println(min + " "+ max);

		
		
//		
//		Scanner in = new Scanner(System.in);
//        
//		int N = in.nextInt();
//		int[] arr = new int[N];
//        
//		for (int i = 0; i < N; i++) {
//			arr[i] = in.nextInt();
//		}
//        
//		in.close();
//		Arrays.sort(arr);
//		System.out.print(arr[0] + " " + arr[N - 1]);

		
		
		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int num = Integer.parseInt(br.readLine());
//		
//		String input = br.readLine();
//		String[] arr = new String[num]; 
//        arr = input.split(" ");
//        int min = Integer.parseInt(arr[0]);
//        int max = 0;
//        for (int i=0; i<num; i++) {
//        	if (Integer.parseInt(arr[i]) > max)
//        		max = Integer.parseInt(arr[i]);
//        	if (Integer.parseInt(arr[i])< min)
//        		min = Integer.parseInt(arr[i]);
//        }
//        System.out.println(min + " "+ max);
	}
}
