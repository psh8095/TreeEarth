package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vo.store.OrderDTO;
import vo.store.OrderDetailDTO;

import static db.JdbcUtil.*;

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
		} finally {
			close(pstmt);
		}
				
		return insertCount;
	}

	public int insertOrderDetail(OrderDetailDTO orderDetail) {
		int insertCount = 0;
		
		int num = 1;
		PreparedStatement pstmt = null, pstmt2 = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT MAX(order_detail_idx) FROM order_detail";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				num = rs.getInt(1) + 1;
			}
			
			sql = "INSERT INTO order_detail VALUES(?,?,?,?)";
			pstmt2 = con.prepareStatement(sql);
			pstmt2.setInt(1, num);
			pstmt2.setString(2, orderDetail.getOrder_id());
			pstmt2.setInt(3, orderDetail.getSto_idx());
			pstmt2.setInt(4, orderDetail.getQuantity());
			
			insertCount = pstmt2.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL 구문 오류 - insertOrderDetail()");
		} finally {
			close(rs);
			close(pstmt);
			close(pstmt2);
		}
		
		return insertCount;
	}
	
	

}
