package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static db.JdbcUtil.*;

import vo.FreeboardDTO;

public class FreeBoardDAO {

	private static FreeBoardDAO instance = new FreeBoardDAO();
	
	private FreeBoardDAO() {}
	
	public static FreeBoardDAO getInstance() {
		return instance;
	}

	private Connection con;

	public void setConnection(Connection con) {
		this.con = con;
	}
	
	// 글쓰기 작업
	public int insertFreeBoard(FreeboardDTO board) {
		int insertCount = 0; // insert 작업결과 리턴받아 저장할 변수 선언
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int idx = 1; // 새 글 번호를 저장할 변수
		
		try {
			String sql = "SELECT MAX(freeboard_num) FROM freeboard";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				idx = rs.getInt(1) + 1; // 조회된 가장 큰 번호 + 1 값을 새 글 번호로 저장
			}
			
			close(pstmt);
			
			sql = "INSERT INTO freeboard VALUES(?,?,?,?,?,?,?,?,?,now))";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, idx);
			pstmt.setString(2, board.getFree_name());
			pstmt.setString(3, board.getFree_pass());
			pstmt.setString(4, board.getFree_subject());
			pstmt.setString(5, board.getFree_content());
			pstmt.setString(6, board.getFree_img());
			pstmt.setString(7, board.getFree_original_img());
			pstmt.setInt(8, 0); // freeboard_readcount
			pstmt.setInt(9, board.getFree_block());

			insertCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL 구문 오류 - insertFreeBoard()");
		} finally {
			close(rs);
			close(pstmt);
		}

		return insertCount;
	}
	

}
