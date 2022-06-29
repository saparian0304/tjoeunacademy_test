package chapter04;

// 증감연산자
public class OpEx3 {

	public static void main(String[] args) {
		int a = 10;
		int b = 10;
		
		++a;	// 전위연산		정확한 표현은 아니나 실행문이 실행되기 전에 연산되었다고 이해하자 
		b++;	// 후위연산		정확한 표현은 아니나 실행문이 실행된 후에 연산되었다고 이해하자
		
		System.out.println(a);
		System.out.println(b);
		
		int x = 10;
		int x2 = x++;
		System.out.println("x는 " + x);
		System.out.println("x2는 " + x2);
		
		int y = 10;
		y += 1; // y++; 와 동일한 표현
	}

}
