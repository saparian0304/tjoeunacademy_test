package standardOfJava.ch6;

public class VarArgsEx {
	// 가변인자를 사용한 메서드
	public static void main(String[] args) {
		String[] strArr = { "100", "200", "300" };
		
		System.out.println(concatenate("", "100", "200", "300"));
		System.out.println(concatenate("-", strArr));
		System.out.println(concatenate(",", new String[] {"1", "2", "3"}));
		System.out.println("[" + concatenate(",", new String[0]) + "]");
		System.out.println("[" + concatenate(",") + "]");
		}
		
	
	// 가변인자를 사용한 메서드 - 매개변수의 개수가 가변적인 메서드를 정의할 수 있음 (JDK 1.5부터)
	static String concatenate(String delim, String... args) { 
		String result = "";
		
		for (String str : args) {
			result += str + delim;
		}
		
		return result;
	}

	/*
	  static String concatenate(String... args) { 
	  return concatenate("", args
	  }
	 */
}
