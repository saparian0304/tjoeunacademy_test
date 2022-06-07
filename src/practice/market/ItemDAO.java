package practice.market;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO {

	Connection conn = null;
	PreparedStatement pstat = null;
	ResultSet rs = null;
	public ItemDAO() {
		try {
			// 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"testuser", 
					"test1234");
			
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
//		System.out.println("데이터베이스 접속");
	}
	
	public int insert(ItemVO vo) {
		int result = 0;
		
		String sql = String.format("INSERT INTO ITEM(itemNo, itemName, price, category) VALUES(ITEM_AUTO.nextval, '%s', %d, '%s')",
				vo.getItemName(), 
				vo.getPrice(),
				vo.getCategory());
		try {
			pstat = conn.prepareStatement(sql);
			result = pstat.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return result;
	}
	
	public List<ItemVO> select() {
		List<ItemVO> itemList = new ArrayList<ItemVO>();
		String sql = "SELECT * FROM ITEM ORDER BY itemNo";
		try {
			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();
			
			while (rs.next()) {
				ItemVO vo = new ItemVO();
				vo.setItemNo(rs.getInt("itemNO"));
				vo.setItemName(rs.getString("itemName"));
				vo.setPrice(rs.getInt("price"));
				vo.setCategory(rs.getString("category"));
				itemList.add(vo);
			}
		} catch (SQLException e) {
			e.getMessage();
		}
		
		return itemList;
	}
}
