package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	
}
