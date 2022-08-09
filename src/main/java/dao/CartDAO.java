package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.store.StoreDTO;

public class CartDAO {
	// --- 싱글톤 패턴 구현 ---
	private static CartDAO instance = new CartDAO();
	
	private CartDAO() {}
	
	public static CartDAO getInstance() {
		return instance;
	}
	
	private Connection con;

	public void setCon(Connection con) {
		this.con = con;
	}
	// --- 싱글톤 패턴 구현 ---

	// 장바구니에 상품 추가하는 메서드 정의
	public boolean insertCart(int sto_idx, String sId) {
		boolean isCart = false;
		
		int num = 1;
		PreparedStatement pstmt = null, pstmt2 = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT MAX(cart_idx) FROM cart WHERE mem_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				num = rs.getInt(1) + 1;
			}
			
			sql = "INSERT INTO cart VALUES(?,?,?)";
			pstmt2 = con.prepareStatement(sql);
			pstmt2.setInt(1, num);
			pstmt2.setString(2, sId);
			pstmt2.setInt(3, sto_idx);
			
			int insertCount = pstmt2.executeUpdate();
			
			if(insertCount > 0) {
				isCart = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL 구문 오류 - insertCart()");
		}
		
		return isCart;
	}

	// 장바구니 조회하는 메서드 정의
	public List<StoreDTO> selectCartList(String sId) {
		List<StoreDTO> list = null;
		
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		
//		String sql = "SELECT sto_idx FROM cart WHERE mem_id=?";
//		pstmt = con.prepareStatement(sql);
//		pstmt.setString(1, sId);
//		rs = pstmt.executeQuery();
//		
//		list = new ArrayList<StoreDTO>();
//		while(rs.next()) {
//			StoreDTO store = new StoreDTO();
//			
//		}
		
		return list;
	}
	
}
