package practice.market;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		List<Item> itemList = new ArrayList<Item>();
		List<Order> orderList = new ArrayList<Order>();
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("=========================================================================");
			System.out.println("1. 상품 입력 | 2. 상품목록 | 3. 상품구매 | 4. 장바구니 확인 | 5. 프로그램 종료");		// 카테고리, 상품번호, 상품명, 가격 -> 상품목록 리스트에 add
			System.out.println("=========================================================================");
//			System.out.println("2. 상품 목록");		// 상품목록 리스트 toString 
//			System.out.println("3. 상품 구매");		// 상품번호, 수량 -> 장바구니리스트에 add
//			System.out.println("4. 장바구니 확인");	// 장바구니 리스트 toString 메소드 Override (상품종류, 수량, 단계, 총계)
//			System.out.println("5. 프로그램 종료");
			System.out.println("진행하고 싶은 메뉴를 입력해주세요(1~5) : ");
			String temp = sc.nextLine();
			int input = 0;
			input = checkNum(input, temp);
			
			if (input == 1) {
				Item i = new Item();
				menu("1. 상품 입력");
				System.out.print("상품 번호: ");
				i.setItemNo(sc.nextInt());
				System.out.print("상품명: ");
				i.setItemName(sc.next());
				System.out.print("상품 가격: ");
				i.setPrice(sc.nextInt());
				itemList.add(i);
			} else if (input == 2) {
				menu("2. 상품 목록");
				listOfItem(itemList);
			} else if (input == 3) {
				menu("3. 상품 구매");
				System.out.print("구매할 상품 번호를 입력해주세요");
				Order o = new Order();
				int no = sc.nextInt();
				for (int i=0; i<itemList.size(); i++) {
					if (no == itemList.get(i).getItemNo()) {
						o.setI(itemList.get(i));
						break;
					}
				}
				System.out.print("구매 수량을 입력해주세요");
				o.setCount(sc.nextInt());
				orderList.add(o);
			} else if (input == 4) {
				menu("4. 장바구니 확인");
				int sum = 0;
				System.out.println("상품번호\t상품명\t가격");
				for (int i=0; i<orderList.size(); i++) {
					System.out.printf("%s\t%d\t%d%n",
							orderList.get(i).getI().getItemName(), 
							orderList.get(i).getCount(), 
							orderList.get(i).getI().getPrice()*orderList.get(i).getCount() );
					sum += orderList.get(i).getI().getPrice()*orderList.get(i).getCount();
				}
				System.out.println("합계 : " + sum);
			}	else if ( input == 5) {
				System.out.println("프로그램 종료");
				break;
			}
		}
		
	}
	// 메뉴 선택 확인 메서드
	public static void menu(String str) {
		System.out.println("====================");
		System.out.println(str);
		System.out.println("====================");
	}
	
	// 상품 목록 메서드
	public static void listOfItem(List<Item> list) {
		System.out.println("상품번호\t상품명\t가격");
		for(int i=0; i<list.size();i++) {
			System.out.printf("%d\t%s\t%d 원%n",
					list.get(i).getItemNo(), 
					list.get(i).getItemName(), 
					list.get(i).getPrice());
		}
	}

	public static int checkNum(int n, String temp) {
		try {
			n = Integer.parseInt(temp);
			if (n < 1 || n > 5) 
				System.out.println("잘못입력하셨습니다. 다시 입력해주세요");
			return n;
		} catch (Exception e) {
			System.out.println("잘못입력하셨습니다. 다시 입력해주세요");
			return 0;
		}
		
	}
}
