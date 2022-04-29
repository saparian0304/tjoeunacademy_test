
public class PropertyEx2 {

	public static void main(String[] args) {
		
		// getenv() : 환경변수를 읽어올 수 있다
		for (String var : System.getenv().keySet()) {
			System.out.println(var + "=" + System.getenv(var));
		}
	}

}
