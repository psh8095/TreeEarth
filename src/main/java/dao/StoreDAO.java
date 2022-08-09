package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.StoreDTO;

public class StoreDAO {
private static StoreDAO instance = new StoreDAO();
	
	private StoreDAO() {}
	
	public static StoreDAO getInstance() {
		return instance;
	}

	private Connection con;

	public void setConnection(Connection con) {
		this.con = con;
	}
	
	// 상품등록(글쓰기) 작업을 수행하는 메서드
	public int insertStore(StoreDTO sto) {
		int insertCount = 0; // insert 작업결과 리턴받아 저장할 변수 선언
		
		PreparedStatement pstmt = null;
//		ResultSet rs = null;
		
//		int idx = 1; // 새 글 번호를 저장할 변수
		
		try {
//			String sql = "SELECT MAX(sto_idx) FROM store";
//			pstmt = con.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//			
//			if(rs.next()) {
//				idx = rs.getInt(1) + 1; // 조회된 가장 큰 번호 + 1 값을 새 글 번호로 저장
//			}
//			
//			close(pstmt);
			
			String sql = "INSERT INTO store VALUES(?,?,?,?,?,?,?,?,?,?,now))";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, sto.getSto_idx());
			pstmt.setInt(2, sto.getSto_price());
			pstmt.setString(3, sto.getSto_subject());
			pstmt.setString(4, sto.getSto_content());
			pstmt.setString(5, sto.getSto_tag());
			pstmt.setString(6, sto.getSto_category());
			pstmt.setDate(7, sto.getSto_date());
			pstmt.setString(8, sto.getSto_thum_file());
			pstmt.setString(9, sto.getSto_thum_real_file());
			pstmt.setString(10, sto.getSto_content_file());
			pstmt.setString(11, sto.getSto_content_real_file());
			
			insertCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL 구문 오류 - insertStore()");
		} finally {
//			close(rs);
			close(pstmt);
		}

		return insertCount;
	}
	
	// 전체게시물 수를 조회하는 메서드
	public int selectListCount() {
		int listCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql ="SELECT COUNT(*) FROM store";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				listCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL 구문 오류 - selectListCount()" + e.getMessage());
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return listCount;
	}
	
	// 게시물 목록을 조회하는 메서드
	public ArrayList<StoreDTO> selectStoreList(int pageNum, int listLimit) {
		ArrayList<StoreDTO> boardList = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int startRow = (pageNum - 1) * listLimit;
		
		try {
			String sql = "SELECT * FROM store LIMIT ?,?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, listLimit);
			
			rs = pstmt.executeQuery();
			
			boardList = new ArrayList<StoreDTO>();
			
			while(rs.next()) {
				StoreDTO sto = new StoreDTO();
				
				pstmt.setInt(1, sto.getSto_idx());
				pstmt.setInt(2, sto.getSto_price());
				pstmt.setString(3, sto.getSto_subject());
				pstmt.setString(4, sto.getSto_content());
				pstmt.setString(5, sto.getSto_tag());
				pstmt.setString(6, sto.getSto_category());
				pstmt.setDate(7, sto.getSto_date());
				pstmt.setString(8, sto.getSto_thum_file());
				pstmt.setString(9, sto.getSto_thum_real_file());
				pstmt.setString(10, sto.getSto_content_file());
				pstmt.setString(11, sto.getSto_content_real_file());
				
				boardList.add(sto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL 구문 오류 - selectStoreList()" + e.getMessage());
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return boardList;
	}
	
	// 1개 게시물의 상세정보를 조회하는 메서드
	public StoreDTO selectStore(int sto_idx) {
		StoreDTO sto = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM store WHERE sto_idx=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, sto_idx);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				sto = new StoreDTO();
				pstmt.setInt(1, sto.getSto_idx());
				pstmt.setInt(2, sto.getSto_price());
				pstmt.setString(3, sto.getSto_subject());
				pstmt.setString(4, sto.getSto_content());
				pstmt.setString(5, sto.getSto_tag());
				pstmt.setString(6, sto.getSto_category());
				pstmt.setDate(7, sto.getSto_date());
				pstmt.setString(8, sto.getSto_thum_file());
				pstmt.setString(9, sto.getSto_thum_real_file());
				pstmt.setString(10, sto.getSto_content_file());
				pstmt.setString(11, sto.getSto_content_real_file());
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL 구문 오류 - selectStore() : " + e.getMessage());
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return sto;
	}
	
	// 글 삭제 권한을 판별하는 메서드
	public boolean isStoreWriter(int sto_idx) {
		boolean isStoreWriter = false;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM store WHERE sto_idx=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, sto_idx);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				// 조회 결과 있음
				isStoreWriter = true; // 결과값을 true 로 변경
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL 구문 오류 - isStoreWriter() : " + e.getMessage());
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return isStoreWriter;
	}
	
	// 게시글을 삭제하는 메서드
	public int deleteStore(int sto_idx) {
		int deleteCount = 0;
		
		PreparedStatement pstmt = null;
		
		try {
			String sql = "DELETE FROM store WHERE sto_idx=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, sto_idx);
			deleteCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL 구문 오류 - deleteStore() : " + e.getMessage());
		} finally {
			close(pstmt);
		}
		
		return deleteCount;
	}
	
	// 게시글 수정하는 메서드
	public int updateStore(StoreDTO sto) {
		int updateCount = 0;
		
		PreparedStatement pstmt = null;
		
		try {
			String sql = "UPDATE store "
					+ "SET sto_subject=?,sto_content=? "
					+ "WHERE sto_idx=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sto.getSto_subject());
			pstmt.setString(2, sto.getSto_content());
			pstmt.setInt(3, sto.getSto_idx());
			
			updateCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL 구문 오류 - updateStore() : " + e.getMessage());
		} finally {
			close(pstmt);
		}
		
		return updateCount;
	}
	
	// 조회수 증가 작업을 처리하는 updateReadcount() 메서드 
	public void updateReadcount(int sto_idx) {
		
	}
	
	// 1개 게시물의 상세 정보 조회 작업 수행하는 selectStore() 메서드 
	public StoreDTO selectStore(int sto_idx) {

		return null;
	}
	
}
