package practice.market;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		List<ItemVO> itemList = new ArrayList<ItemVO>();
		List<Order> orderList = new ArrayList<Order>();
		ItemDAO dao = new ItemDAO();
		itemList = dao.select();
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("=========================================================================");
			System.out.println("1. 상품 입력 | 2. 상품목록 | 3. 상품구매 | 4. 장바구니 확인 | 5. 프로그램 종료 | 6. 로그인");		// 카테고리, 상품번호, 상품명, 가격 -> 상품목록 리스트에 add
			System.out.println("=========================================================================");
			System.out.println("진행하고 싶은 메뉴를 입력해주세요(1~5) : ");
			int input = inputNum();
			
			// 상품 입력시 중복여부 체크필요
			// 에러가 리턴될 경우 종료
			if (input == 1) {
				ItemVO i = new ItemVO();
				menu("1. 상품 입력");
				
				System.out.print("상품명: ");
				i.setItemName(sc.nextLine());

				System.out.print("상품 가격: ");
				int tempNo = inputNum();
				if (tempNo != 0 ) {
					i.setPrice(tempNo);
				} else {
					continue;
				}
				
				System.out.print("카테고리: ");
				i.setCategory(sc.nextLine());
				dao = new ItemDAO();
				dao.insert(i);
				try {
					dao.conn.close();
				} catch (SQLException e){  e.getMessage(); }
				
			} else if (input == 2) {
				itemList.clear();
				dao = new ItemDAO();
				listOfItem(dao.select());
				try {
					dao.conn.close();
				} catch (SQLException e){  e.getMessage(); }
				
			} else if (input == 3) {
				menu("3. 상품 구매");
				itemList.clear();
				dao = new ItemDAO();
				itemList = dao.select();
				listOfItem(itemList);
				System.out.print("구매할 상품 번호를 입력해주세요. : ");
				Order o = new Order();
				int no = inputNum();	
				System.out.println();
				for (int i=0; i<itemList.size(); i++) {
					if (no == itemList.get(i).getItemNo()) {
						o.setI(itemList.get(i));
						break;
					}
				}
				if(o.getI().getItemName() == null) {
					System.out.println("입력하신 상품은 존재하지 않습니다.");
					continue;
				}
				System.out.print("구매 수량을 입력해주세요");
				int tempNo = inputNum();
				if (tempNo != 0) {
					o.setCount(tempNo);
					orderList.add(o);
				}
			} else if (input == 4) {
				menu("4. 장바구니 확인");
				int sum = 0;
				System.out.printf("상품번호\t            상품명\t주문수량\t가격\n");
				for (int i=0; i<orderList.size(); i++) {
					System.out.printf("%d\t%15s\t%d\t%d%n",
							orderList.get(i).getI().getItemNo(), 
							orderList.get(i).getI().getItemName(),
							orderList.get(i).getCount(),
							orderList.get(i).getI().getPrice()*orderList.get(i).getCount() );
					sum += orderList.get(i).getI().getPrice()*orderList.get(i).getCount();
				}
				System.out.println("합계 : " + sum);
			}	else if ( input == 5) {
				System.out.println("프로그램 종료");
				try {
					dao.conn.close();
				} catch (SQLException e){  e.getMessage(); }
				break;
			} else if ( input == 6) {
				menu("6. 로그인");
				System.out.print("아이디 : ");
				String temp = sc.nextLine();
				
				
			} else {
				System.out.println("잘못 입력하셨습니다.");
			}
		}
		sc.close();
	}
	
	
	// 메뉴 선택 확인 메서드
	public static void menu(String str) {
		System.out.println("====================");
		System.out.println(str);
		System.out.println("====================");
	}
	
	/**
	 * 상품목록 메서드
	 * @param list
	 */
	public static void listOfItem(List<ItemVO> list) {
		System.out.printf("상품번호\t            상품명   \t가격\t카테고리%n");
		for(int i=0; i<list.size();i++) {
			System.out.printf("%d\t%15s\t%d 원\t%s%n",
					list.get(i).getItemNo(), 
					list.get(i).getItemName(), 
					list.get(i).getPrice(),
					list.get(i).getCategory());
		}
	}
	/**
	 * 숫자 입력받기
	 * @return 숫자가 아니면 0을 반환
	 */
	public static int inputNum() {
		Scanner scan = new Scanner(System.in);
		String temp = scan.nextLine();
		try {
			int no = Integer.parseInt(temp);
			return no;
		} catch (Exception e) {
			System.out.println("숫자를 입력해주세요.");
			return 0;
		}
	}
}
