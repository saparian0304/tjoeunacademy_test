package chapter08;

public class SmartPhone extends Phone {
	public void installApp() {
		System.out.println("앱 설치");
	}
	
	/*
		상속받은 Phone 클래스의 모든 멤버도 포함하고 있음
		public class Phone {
		
			String name;
			String color;
			String company;
			
			void call() {
				System.out.println("전화를 건다");
			}
			
			void receive() {
				System.out.println("전화를 받다");
			}
	
		}
	 */
	
}
