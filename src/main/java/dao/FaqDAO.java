package dao;

import static db.JdbcUtil.close;

import java.sql.*;
import java.util.*;

import vo.community.*;

public class FaqDAO {
	
	//인스턴스 생성
	private static FaqDAO instance = new FaqDAO();
	
	//생성자
	private FaqDAO() {}

	//getter
	public static FaqDAO getInstance() {
		return instance;
	}

	public static void setInstance(FaqDAO instance) {
		FaqDAO.instance = instance;
	}

	//con
	private Connection con;
	public void setConnection(Connection con) {
		this.con = con;
	}

	//Faq 글쓰기 작업
	public int insertFaq(QnaFaqDTO qnafaq) {
		
		int insertCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int num = 1;
		
		try {
			//글 번호 설정
			String sql = "SELECT MAX(faq_idx) FROM qnafaq";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				num = rs.getInt(1) + 1;
			}
			
			close(pstmt);
			
			//데이터 insert
			sql = "INSERT INTO qnafaq VALUES (?,?,?,now())";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, qnafaq.getFaq_subject());
			pstmt.setString(3, qnafaq.getFaq_content());
			
			insertCount = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("FaqDAO - insertFaq 오류");
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return insertCount;
	}

	//전체 게시물 수 조회
	public int selectListCount() {
		
		int itemlistCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT COUNT(*) FROM qnafaq";
			pstmt = con.prepareStatement(sql);
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
	public ArrayList<QnaFaqDTO> selectFaqList(int pageNum, int listLimit) {
		
		ArrayList<QnaFaqDTO> qnaFaqList = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int startRow = (pageNum - 1) * listLimit;
		
		try {
			String sql = "SELECT * FROM qnafaq LIMIT ?,?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, listLimit);
			
			rs = pstmt.executeQuery();
			
			qnaFaqList = new ArrayList<QnaFaqDTO>();
			
			while(rs.next()) {
				QnaFaqDTO qnafaq = new QnaFaqDTO();
				qnafaq.setFaq_idx(rs.getInt("faq_idx"));
				qnafaq.setFaq_subject(rs.getString("faq_subject"));
				qnafaq.setFaq_content(rs.getString("faq_content"));
				qnafaq.setFaq_date(rs.getDate("faq_date"));
				
				qnaFaqList.add(qnafaq);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("FaqDAO - selectFaqList 오류");
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return qnaFaqList;
	}
	
}
