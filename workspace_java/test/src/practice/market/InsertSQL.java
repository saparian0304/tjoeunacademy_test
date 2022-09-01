package practice.market;

public class InsertSQL {

	public static void main(String[] args) {
		
		// 이디야 2022년 메뉴 일부
		String[] menu = {"에스프레소", "카페 아메리카노", "카페라떼", "카푸치노", "아인슈페너",
				"연유 카페라떼", "카페모카", "화이트 초콜릿 모카", "바닐라라떼", "카라멜마끼아또",
				"민트 모카", "아포가토", "콜드브루 아메리카노", "흑당 콜드브루", "콜드브루 니트로"};
		int[] price = {2900, 3200, 3700, 3700, 3700,
				3800, 3900, 3900, 3900, 3900, 
				4200, 4500, 3700, 3700, 3900};
		String[] category = {"에스프레소 커피", "에스프레소 커피", "에스프레소 커피", "에스프레소 커피", "에스프레소 커피", 
				"에스프레소 커피", "에스프레소 커피", "에스프레소 커피", "에스프레소 커피", "에스프레소 커피", 
				"에스프레소 커피", "에스프레소 커피", "콜드브루 커피", "콜드브루 커피",  "콜드브루 커피"};
		
		for (int i=0; i<15; i++) {
			String str = String.format("INSERT INTO ITEM VALUES (ITEM_AUTO.nextval, %d, '%s', '%s');%n", price[i], menu[i], category[i]);
//			String str = String.format("%d\t%15s\t%s%n",
//					price[i], 
//					menu[i], 
//					category[i] );
			
			System.out.printf(str);
		}
	}
}
