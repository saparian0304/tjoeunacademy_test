package chapter08.pkg2;

import chapter08.pkg1.Aclass;

public class CClass extends Aclass {	// 다른 패키지이나 상속관계
	
	CClass() {
		// protected : 다른 패키지에 있어도 상속관계면 사용 가능
		this.varA = "varA";		 
		this.methodA();			
		// default : 다른 패키지에선 사용불가
		this.varA2 = "varA2";	
		this.methodA2();		
	}
}
