package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vo.community.CommentDTO;

import static db.JdbcUtil.*;

public class CommentDAO {
	
	private static CommentDAO dao = new CommentDAO();
	private CommentDAO() {}
	private static CommentDAO getInstance() {
		return dao;
	}
	
	private Connection con;
	public void serConnection(Connection con) {
		this.con = con;
	}
	
	// comment 테이블의 idx로 데이터 1개 가져오는 메서드
	public CommentDTO getIdx(int idx) {
		
		CommentDTO comment = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM comment WHERE idx = ?";
			
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			
			comment = new CommentDTO();
			comment.setIdx(rs.getInt("idx"));
			comment.setName(rs.getString("name"));
			comment.setPassword(rs.getString("password"));
			comment.setContent(rs.getString("content"));
			comment.setDate(rs.getDate("date"));
			comment.setRef(rs.getInt("ref"));
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL 구문 오류 발생 ! - CommentDAO 의 getIdx() 메서드" + e.getMessage());
		} finally {
			close(rs);
			close(pstmt);
		}
		
		
		return comment;
	}
}
