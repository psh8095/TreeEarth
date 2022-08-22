package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.store.StoreDTO;

public class WishlistDAO {
	// --- 싱글톤 패턴 구현 ---
	private static WishlistDAO instance = new WishlistDAO();
	
	private WishlistDAO() {}
	
	public static WishlistDAO getInstance() {
		return instance;
	}
	
	private Connection con;

	public void setCon(Connection con) {
		this.con = con;
	}
	// --- 싱글톤 패턴 구현 ---

	// 위시리스트 조회 작업
	public List<StoreDTO> selectWishlist(String sId) {
		List<StoreDTO> list = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// 세션아이디 받아와서 위시리스트 테이블에 있는 상품 번호 조회
			String sql = "SELECT * FROM wishlist w JOIN store s ON w.sto_idx = s.sto_idx WHERE mem_id=? ORDER BY wish_idx DESC";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sId);
			rs = pstmt.executeQuery();
			
			list = new ArrayList<StoreDTO>();
			
			while(rs.next()) {
				StoreDTO store = new StoreDTO();
				store.setSto_idx(rs.getInt("sto_idx"));
				store.setSto_price(rs.getInt("sto_price"));
				store.setSto_subject(rs.getString("sto_subject"));
				store.setSto_tag(rs.getString("sto_tag"));
				store.setSto_category(rs.getString("sto_category"));
				store.setSto_thum_file(rs.getString("sto_thum_file"));
				store.setSto_thum_real_file(rs.getString("sto_thum_real_file"));
				
				list.add(store);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL 구문 오류 - selectWishlist()");
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return list;
	}
	
	// 위시리스트 추가 작업
	public boolean insertWishlist(int sto_idx, String sId) {
		boolean isInsert = false;
		
		int num = 1;
		PreparedStatement pstmt = null, pstmt2 = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT MAX(wish_idx) FROM wishlist";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				num = rs.getInt(1) + 1;
			}
			
			sql = "INSERT INTO wishlist VALUES(?,?,?)";
			pstmt2 = con.prepareStatement(sql);
			pstmt2.setInt(1, num);
			pstmt2.setString(2, sId);
			pstmt2.setInt(3, sto_idx);
			
			int insertCount = pstmt2.executeUpdate();
			
			if(insertCount > 0) {
				isInsert = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL 구문 오류 - insertWishlist()");
		} finally {
			close(rs);
			close(pstmt);
			close(pstmt2);
		}
		
		return isInsert;
	}
		
	// 위시리스트에서 단일 품목 삭제
	public boolean deleteWishlist(int sto_idx, String sId) {
		boolean isDelete = false;
		
		PreparedStatement pstmt = null;
		
		try {
			String sql = "DELETE FROM wishlist WHERE mem_id=? AND sto_idx=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sId);
			pstmt.setInt(2, sto_idx);
			
			int deleteCount = pstmt.executeUpdate();
			
			if(deleteCount > 0) {
				isDelete = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL 구문 오류 - deleteWishlist()");
		} finally {
			close(pstmt);
		}
		
		return isDelete;
	}

	// 위시리스트 전체 삭제
	public boolean deleteWishlist(String sId) {
		boolean isDelete = false;
		
		PreparedStatement pstmt = null;
		
		try {
			String sql = "DELETE FROM wishlist WHERE mem_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sId);
			
			int deleteCount = pstmt.executeUpdate();
			
			if(deleteCount > 0) {
				isDelete = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL 구문 오류 - deleteWishlist()");
		} finally {
			close(pstmt);
		}
		
		return isDelete;
	}
}
