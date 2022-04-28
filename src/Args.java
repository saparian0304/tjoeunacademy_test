
public class Args {

	public static void main(String[] args) {
		// 메서드 실행
//		gugu(10);

		if (args.length == 0) {
			System.out.println("이름을 입력해주세요");
		} else {
			for(int i=0; i<args.length; i++) {
				String text = greet(args[i]);
				System.out.println(text);
			}
		}
	}

	// 해당 단을 출력해주는 메서드
	public static void gugu(int dan) {
		for (int i = 1; i <= 9; i++) {
			System.out.println(dan + " * " + i + " = " + dan * i);
		}
	}

	// 이름을 입력받아서 인사말을 출력해주는 메서드
	public static String greet(String name) {
		String text = "안녕하세요 저는 " + name + "입니다.";
		return text; // 실행한 곳으로 돌려줌
	}
}
