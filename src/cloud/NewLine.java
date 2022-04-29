package cloud;

public class NewLine {
	public static void main(String[] arguments) {
		System.out.println("Line 1");
		threeLines();
		System.out.println("Line 2");
	}

	public static void threeLines() {
		oneLine();
		oneLine();
		oneLine();
	}

	public static void oneLine() {
		System.out.println(">");
	}
}
