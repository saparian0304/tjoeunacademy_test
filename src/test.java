import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int cycle = Integer.parseInt(str);
		String[] arr = new String[2];
		
		int num = 0;
		
		for (int i=0; i<cycle; i++) {
			str = br.readLine();
			arr = str.split(" ");
			num = Integer.parseInt(arr[0]);
			
			for (int j=0; j<arr[1].length(); j++) {
				for (int k=0; k<num; k++)
				System.out.print(arr[1].charAt(j));
			}
			System.out.println();
		}
    }
}
