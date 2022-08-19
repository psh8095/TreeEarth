package dao;

import static db.JdbcUtil.close;

import java.sql.*;
import java.util.*;

import vo.community.*;

public class QnaDAO {
	
	//인스턴스 생성
	private static QnaDAO instance = new QnaDAO();
	
	//생성자
	private QnaDAO() {}

	//getter
	public static QnaDAO getInstance() {
		return instance;
	}

	public static void setInstance(QnaDAO instance) {
		QnaDAO.instance = instance;
	}

	//con
	private Connection con;
	public void setConnection(Connection con) {
		this.con = con;
	}

	//글쓰기 작업
	public int insertQna(QnaDTO qna) {
		
		int insertCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int num = 1;
		
		try {
			//글 번호 설정
			String sql = "SELECT MAX(qna_idx) FROM qna";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				num = rs.getInt(1) + 1;
			}
			
			close(pstmt);
			
			//데이터 insert
			sql = "INSERT INTO qna VALUES (?,?,?,?,?,now())";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, qna.getQna_id());
			pstmt.setString(3, qna.getQna_tag());
			pstmt.setString(4, qna.getQna_subject());
			pstmt.setString(5, qna.getQna_content());
			
			insertCount = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("QnaDAO - insertQna 오류");
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return insertCount;
	}

	//전체 게시물 수 조회
	public int selectListCount(String qna_tag) {
		
		int itemlistCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT COUNT(*) FROM qna WHERE qna_tag=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, qna_tag);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				itemlistCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("FaqDAO - selectListCount 오류");
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return itemlistCount;
	}

	//게시물 목록 조회
	public ArrayList<QnaDTO> selectQnaList(int pageNum, int listLimit, String qna_tag) {
		
		ArrayList<QnaDTO> qnaList = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int startRow = (pageNum - 1) * listLimit;
		
		try {
			String sql = "SELECT * FROM qna WHERE qna_tag=? LIMIT ?,?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, qna_tag);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, listLimit);
			
			rs = pstmt.executeQuery();
			
			qnaList = new ArrayList<QnaDTO>();
			
			while(rs.next()) {
				QnaDTO qna = new QnaDTO();
				qna.setQna_idx(rs.getInt("qna_idx"));
				qna.setQna_id(rs.getString("qna_id"));
				qna.setQna_tag(rs.getString("qna_tag"));
				qna.setQna_subject(rs.getString("qna_subject"));
				qna.setQna_content(rs.getString("qna_content"));
				qna.setQna_date(rs.getDate("qna_date"));
				
				qnaList.add(qna);
				System.out.println(qna);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("FaqDAO - selectQnaList 오류");
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return qnaList;
	}
  
	//삭제 권한 판별
	public boolean isQnaWriter(int qna_idx, String mem_pass) {
		
		boolean isQnaFaqWriter = false;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM qna q, member m WHERE q.qna_id = m.mem_id AND qna_idx=? AND mem_pass =?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, qna_idx);
			pstmt.setString(2, mem_pass);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				isQnaFaqWriter = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("QnaDAO - isQnaWriter 오류");
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return isQnaFaqWriter;
	}

	//
	public int deleteQna(int qna_idx) {
		
		int deleteCount = 0;
		
		PreparedStatement pstmt = null;
		
		try {
			String sql = "DELETE FROM qna WHERE qna_idx=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, qna_idx);
			
			deleteCount = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("QnaDAO - deleteQna 오류");
		} finally {
			close(pstmt);
		}
		
		return deleteCount;
	}
	
}
