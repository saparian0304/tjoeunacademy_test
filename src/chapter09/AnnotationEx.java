package chapter09;

import java.lang.reflect.Method;

public class AnnotationEx {

	public static void main(String[] args) throws Exception {
		// UserClass에 있는 메서드들을 객체로 만들어서 Method 타입의 배열에 담는다.
		Method method[] = UserClass.class.getDeclaredMethods();
		
		for (int i=0; i<method.length; i++) {
			// 메서드의 이름을 읽어옴
			String methodName = method[i].getName();
			// 메서드에 있는 annotation을 읽어옴
			UserAnnot annot = method[i].getAnnotation(UserAnnot.class);
			
			System.out.print(methodName + "의 어노테이션 ");
			System.out.print("value : " + annot.value() + " ");
			System.out.print("number : " + annot.number() + " ");
			System.out.println();
			
			// 메서드타입 변수에 담긴 메서드 실행
			method[i].invoke(new UserClass(), null);	// 메서드 실행
		}
	}

}
