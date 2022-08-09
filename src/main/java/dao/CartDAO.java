package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.store.StoreDTO;
import static db.JdbcUtil.*;


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
		} finally {
			close(rs);
			close(pstmt);
			close(pstmt2);
		}
		
		return isCart;
	}

	// 장바구니 조회하는 메서드 정의
	public List<StoreDTO> selectCartList(String sId) {
		List<StoreDTO> list = null;
		
		PreparedStatement pstmt = null, pstmt2 = null;
		ResultSet rs = null, rs2 = null;
		
		try {
			String sql = "SELECT sto_idx FROM cart WHERE mem_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sId);
			rs = pstmt.executeQuery();
			
			list = new ArrayList<StoreDTO>();
			while(rs.next()) {
				StoreDTO store = new StoreDTO();
				
				sql = "SELECT * FROM store WHERE sto_idx=?";
				pstmt2 = con.prepareStatement(sql);
				pstmt2.setInt(1, rs.getInt(1));
				rs2 = pstmt2.executeQuery();
				
				if(rs2.next()) {
					store.setSto_idx(rs2.getInt("sto_idx"));
					store.setSto_price(rs2.getInt("sto_price"));
					store.setSto_subject(rs2.getString("sto_subject"));
					store.setSto_tag(rs2.getString("sto_tag"));
					store.setSto_category(rs2.getString("sto_category"));
					store.setSto_thum_file(rs2.getString("sto_thum_file"));
					store.setSto_thum_real_file(rs2.getString("sto_thum_real_file"));
				}
				
				list.add(store);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL 구문 오류 - selectCartList()");
		} finally {
			close(rs);
			close(rs2);
			close(pstmt);
			close(pstmt2);
		}
		
		return list;
	}
	
}
