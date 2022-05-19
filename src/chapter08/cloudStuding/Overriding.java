package chapter08.cloudStuding;

public class Overriding {
	  public static void main(String[] args) {
	    // 객체 생성 및 초기화 - 정사각형
	    Square s = new Square();
	    s.name = "정사각형";
	    s.length = 5;
	    
	    // 객체 생성 및 초기화 - 정삼각형
	    Triangle t = new Triangle();
	    t.name = "삼각형";
	    t.base = 4;
	    t.height = 3;
	    
	    // 객체 생성 및 초기화 - 원
	    Circle c = new Circle();
	    c.name = "원";
	    c.radius = 4;

	    // 업 캐스팅 - 도형 배열에 정사각형, 삼각형, 원 담기
	    Shape[] shapes = { s, t, c };
	    
	    // 모든 도형의 넓이 계산 및 출력
	    for (int i = 0; i < shapes.length; i++) {
	      Shape tmp = shapes[i];
	      System.out.printf("%s의 넓이 -> %.2f\n", tmp.name, tmp.area());
	    }
	  }
	}

	// 도형
	class Shape {
	  String name;

	  // 도형의 넓이를 반환
	  public double area() {
	    return 0;
	  }
	}

	// 정사각형
	class Square extends Shape {
	  int length; // 한 변의 길이

	  /* 1. 정사각형 넓이를 구하도록 area()를 재정의하세요. */
	  public double area() {
		  return length * length;		  
	  }
	}

	// 삼각형
	class Triangle extends Shape {
	  int base;   // 밑변
	  int height; // 높이

	  /* 2. 삼각형 넓이를 구하도록 area()를 재정의하세요. */
	  public double area() {
		  return (double)base * height / 2;
	  }
	}

	// 원
	class Circle extends Shape {
	  int radius; // 반지름

	  /* 3. 원의 넓이를 구하도록 area()를 재정의하세요. */  
	  public double area() {
		  return Math.PI * radius * radius;
	  }
	}