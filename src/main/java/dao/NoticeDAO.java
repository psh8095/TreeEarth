package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.community.NoticeDTO;

import static db.JdbcUtil.*;

public class NoticeDAO {
	
	//싱글톤 디자인 패턴
	private static NoticeDAO instance = new NoticeDAO();
	
	private NoticeDAO() {}
	
	public static NoticeDAO getInstance() {
		return instance;
	}

	private Connection con;
	
	public void setConnection(Connection con) {
		this.con = con;
	}

	
	// 새 글 작성 메서드
	public int insertNotice(NoticeDTO notice) {
		int insertCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int num = 1;
		
		try {
			// 새 글 번호 저장
			String sql = "SELECT MAX(no_idx) FROM notice";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				num = rs.getInt(1) + 1;
			}
			
			close(pstmt);
			
			// 새 글 DB에 저장
			sql = "INSERT INTO notice VALUES (?,?,?,?,?,now())";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, notice.getNo_id());
			pstmt.setString(3, notice.getNo_subject());
			pstmt.setString(4, notice.getNo_content());
			pstmt.setString(5, notice.getNo_img());
			
			insertCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("NoticeDAO - insertNotice() 메서드 오류");
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return insertCount;
	}
	
	// 전체 게시물 수 조회 메서드
	public int selectListCount() {
		int listCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT COUNT(*) FROM notice";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				listCount = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("NoticeDAO - selectListCount() 메서드 오류");
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return listCount;

	}
	
	// 전체 게시물 목록 조회 메서드
	public ArrayList<NoticeDTO> selectNoticeList(int pageNum, int listLimit) {
		ArrayList<NoticeDTO> noticeList = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int startRow = (pageNum - 1) * listLimit;
		
		try {
			String sql = "SELECT * FROM notice ORDER BY no_idx LIMIT ?,?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, listLimit);
			
			rs = pstmt.executeQuery();
			
			noticeList = new ArrayList<NoticeDTO>();
			
			while(rs.next()) {
				NoticeDTO notice = new NoticeDTO();
				
				notice.setNo_idx(rs.getInt("no_idx"));
				notice.setNo_id(rs.getString("no_id"));
				notice.setNo_subject(rs.getString("no_subject"));
				notice.setNo_content(rs.getString("no_content"));
				notice.setNo_img(rs.getString("no_img"));
				notice.setNo_date(rs.getDate("no_date"));
				
				noticeList.add(notice);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("NoticeDAO - selectNoticeList() 메서드 오류");
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return noticeList;
	}
	
	
	//게시물 1개 상세 정보 조회
	public NoticeDTO selectNoticeDetail(int no_idx) {

		NoticeDTO notice = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM notice WHERE no_idx=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no_idx);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				notice = new NoticeDTO();
				notice.setNo_idx(rs.getInt("no_idx"));
				notice.setNo_id(rs.getString("no_id"));
				notice.setNo_subject(rs.getString("no_subject"));
				notice.setNo_content(rs.getString("no_content"));
				notice.setNo_img(rs.getString("no_img"));
				notice.setNo_date(rs.getDate("no_date"));
				
//				System.out.println(notice);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("NoticeDAO - selectNoticeDetail() 메서드 오류");
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return notice;
	}
	
	//게시물 수정
	public int updateNotice(NoticeDTO notice) {

		int updateCount = 0;
		
		PreparedStatement pstmt = null;
		
		try {
			String sql = "UPDATE notice SET no_subject=?, no_content=? WHERE no_idx=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, notice.getNo_subject());
			pstmt.setString(2, notice.getNo_content());
			pstmt.setInt(3, notice.getNo_idx());
			
			updateCount = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("NoticeDAO - updateNotice() 메서드 오류");
		}
		
		return updateCount;
	}
	
	//캠페인후기 글 삭제
	public int deleteNotice(int no_idx) {

		int deleteCount = 0;
		
		PreparedStatement pstmt = null;
		
		try {
			String sql = "DELETE FROM notice WHERE no_idx=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no_idx);
			
			deleteCount = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("NoticeDAO - deleteNotice() 메서드 오류");
		} finally {
			close(pstmt);
		}
		
		return deleteCount;
	}
	
	//글 권한
	public boolean isNoticeWriter(int no_idx, String mem_pass) {
		
		boolean isNoticeWriter = false;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM notice n, member m WHERE n.no_id = m.mem_id AND m.mem_pass = ? AND n.no_idx = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mem_pass);
			pstmt.setInt(2, no_idx);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				isNoticeWriter = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("NoticeDAO - isNoticeWriter() 메서드 오류");
			} finally {
				close(rs);
				close(pstmt);
			}
			
			return isNoticeWriter;
		}
}


















