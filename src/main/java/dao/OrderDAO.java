package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import vo.store.OrderDTO;


public class OrderDAO {
	// --- 싱글톤 패턴 구현 ---
	private static OrderDAO instance = new OrderDAO();
	
	private OrderDAO() {}
	
	public static OrderDAO getInstance() {
		return instance;
	}
	
	private Connection con;

	public void setCon(Connection con) {
		this.con = con;
	}
	// --- 싱글톤 패턴 구현 ---

	// 주문 정보 DB에 저장
	public int insertOrder(OrderDTO order) {
		int insertCount = 0;
		
		PreparedStatement pstmt = null;
		
		try {
			String sql = "INSERT INTO order_info VALUES(?,?,?,?,?,?,?,?,now())";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, order.getOrder_id());
			pstmt.setString(2, order.getMem_id());
			pstmt.setString(3, order.getMem_name());
			pstmt.setString(4, order.getMem_address());
			pstmt.setString(5, "-");
			pstmt.setString(6, order.getMem_phone());
			pstmt.setString(7, order.getMem_email());
			pstmt.setInt(8, order.getAmount());
			
			insertCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL 구문 오류 - insertOrder()");
		}
				
		return insertCount;
	}
	
	

}
