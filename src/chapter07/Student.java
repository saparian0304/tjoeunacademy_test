package chapter07;

public class Student {

	// 필드
	String name;	// 학생이름
	int grade;		// 학년
	String department;	// 학과
	
	// 생성자 1(기본생성자)
	Student() {}
	
	// 생성자 2
	
	Student(String name) {
		this.name = name;
	}
	
	// 생성자 3
	Student(String n, int g) {
		name = n;
		grade = g;
	}
	
	// 생성자 4
	Student(String name, int g, String d) {
		this.name = name;
		grade = g;
		department = d;
	}
}
