package chapter04;

public class Excercise3 {

	public static void main(String[] args) {
		
		int colorPen = 5 * 12;
		int studentCount = 27;
		
		int divColorPen = colorPen / studentCount;
		System.out.println("학생당 나눠가지는 색연필 수 :" + divColorPen);

		// int remainColorPen = colorPen - studentCount*divColorPen; 	// 일상적으로 생각하는 방법
		int remainColorPen = colorPen % studentCount;
		System.out.println("똑같이 나눠가지고 남은 볼펜 수 : " + remainColorPen);
	}

}
