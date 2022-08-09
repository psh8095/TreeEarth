package dao;

import static db.JdbcUtil.close;

import java.sql.*;
import java.util.ArrayList;

import vo.community.*;

public class CampaignReviewDAO {

	//싱글톤 디자인 패턴
	private static CampaignReviewDAO instance = new CampaignReviewDAO();
	
	private CampaignReviewDAO() {}
	
	public static CampaignReviewDAO getInstance() {
		return instance;
		
	}	
	
	private Connection con;
	
	public void setConnection(Connection con) {
		this.con = con;
	}

	//작성한 글 insert
	public int insertCampaignReview(CampaignReviewDTO campaign_review) {
		
		int insertCount = 0; 
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int num = 1;
		
		try {
			//새 글 번호 저장 
			String sql = "SELECT MAX(cam_re_idx) FROM campaign_review";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				num = rs.getInt(1) + 1;
			}
			
			close(pstmt);
			
			//새 글 DB에 저장
			sql = "INSERT INTO campaign_review VALUES (?,?,?,?,?,now(),?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, campaign_review.getCam_re_id());
			pstmt.setString(3, campaign_review.getCam_re_subject());
			pstmt.setString(4, campaign_review.getCam_re_content());
			pstmt.setInt(5, 0); //readcount
			pstmt.setString(6, campaign_review.getCam_re_file());
			pstmt.setString(7, campaign_review.getCam_re_real_file());
			pstmt.setString(8, campaign_review.getCam_re_thum_file());
			pstmt.setString(9, campaign_review.getCam_re_thum_real_file());
			
			insertCount = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("CampaignReviewDAO - insertCampaignReview 오류");
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return insertCount;
	}

	//글 상세내용
	public CampaignReviewDTO selectCampaignReviewDetail(int cam_re_idx) {

		CampaignReviewDTO campaign_review = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM campaign_review WHERE cam_re_idx=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, cam_re_idx);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				campaign_review = new CampaignReviewDTO();
				campaign_review.setCam_re_idx(rs.getInt("cam_re_idx"));
				campaign_review.setCam_re_id(rs.getString("cam_re_id"));
				campaign_review.setCam_re_subject(rs.getString("cam_re_subject"));
				campaign_review.setCam_re_content(rs.getString("cam_re_content"));
				campaign_review.setCam_re_readcount(rs.getInt("cam_re_readcount"));
				campaign_review.setCam_re_date(rs.getDate("cam_re_date"));
				campaign_review.setCam_re_file(rs.getString("cam_re_file"));
				campaign_review.setCam_re_real_file(rs.getString("cam_re_real_file"));
				campaign_review.setCam_re_thum_file(rs.getString("cam_re_thum_file"));
				campaign_review.setCam_re_thum_real_file(rs.getString("cam_re_thum_real_file"));
				
				System.out.println(campaign_review);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("CampaignReviewDAO - selectCampaignReviewDetail 오류");
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return campaign_review;
	}

	//전체 게시물 목록 조회
	public int selectListCount() {
		
		int listCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT COUNT(*) FROM board";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				listCount = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("CampaignReviewDAO - selectListCount 오류");
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return listCount;

	}

	public ArrayList<CampaignReviewDTO> selectCampaignReviewList(int pageNum, int listLimit) {
		
		ArrayList<CampaignReviewDTO> campaignReviewList = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "";
		
		return campaignReviewList;
	}
	
}
