package chapter07;

import java.util.Scanner;

import chapter06.Lotto;
import chapter06.Ref;

public class StudentMain {

	public static void main(String[] args) {
		
		Student stu = new Student("홍길동", 4, "소프트웨어공학");
		
		System.out.println(stu.name);
		System.out.println(stu.grade);
		System.out.println(stu.department);

		Student stu2 = new Student("이순신", 3, "디자인");
		
		System.out.println(stu2.name);
		System.out.println(stu2.grade);
		System.out.println(stu2.department);
		
		// 기본생성자로 객체 생성
		Student stu0 = new Student(); 			// 생성자 1 
		Student stu1 = new Student("홍길동");	// 생성자 2
		Student stu3 = new Student("홍길동", 4);// 생성자 3
		Student stu5 = new Student("이순신", 3, "디자인");	// 생성자 4
		
		System.out.println(stu3.department);	// null -> 참조자료형의 기본값
		System.out.println(stu1.grade);			// 0 -> 기본자료형의 기본값
		
		Student stu4 = new Student();
		
		MemberVO m = new MemberVO();
		System.out.println(m.getId());		// private 변수이기때문에 메서드를 통해 접근해줄 수 있음
	
		Scanner scan = new Scanner(System.in);
		Lotto loot = new Lotto();
		Ref ref = new Ref();
		
		
	}

}
