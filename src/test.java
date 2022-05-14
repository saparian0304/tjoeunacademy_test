import java.util.Scanner;

public class test {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        
        String str = sc.nextLine();
        int sum = 0;
        for(int i=0; i<num ; i++) {
        	sum += str.charAt(i) - 48;
        }
        System.out.println(sum);
        // 0 = 48
    }

}
