package chapter08.pkg2;

import chapter08.pkg1.Aclass;	

public class Bclass {
	
	public void methodB() {
		Aclass ac = new Aclass();	// 다른 패키지에 있는 클래스
		// protected
		ac.varA = "varA";		// 사용 불가 : 다른 패키지, 상속X
		ac.methodA();			// 사용 불가 : 다른 패키지, 상속X

		// default
		ac.varA2 = "varA2";		// 사용 불가 : 다른 패키지
		ac.methodA2();			// 사용 불가 : 다른 패키지
		
	}
}
