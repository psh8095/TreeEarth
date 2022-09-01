package dao;

import static db.JdbcUtil.close;

import java.sql.*;
import java.util.*;

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

	//글쓰기 작업 
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

	//게시물 1개 상세 정보 조회
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
				
//				System.out.println(campaign_review);
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

	//전체 게시물 수 조회
	public int selectListCount() {
		
		int listCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT COUNT(*) FROM campaign_review";
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

	//전체 게시물 목록 조회
	public ArrayList<CampaignReviewDTO> selectCampaignReviewList(int pageNum, int listLimit) {
		
		ArrayList<CampaignReviewDTO> campaignReviewList = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int startRow = (pageNum - 1) * listLimit;
		
		try {
			//캠페인 후기 목록 조회(최신순)
			String sql = "SELECT * FROM campaign_review ORDER BY cam_re_idx DESC LIMIT ?,?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, listLimit);
			
			rs = pstmt.executeQuery();
			
			campaignReviewList = new ArrayList<CampaignReviewDTO>();
			
			while(rs.next()) {
				CampaignReviewDTO campaign_review = new CampaignReviewDTO();
				
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
				
				campaignReviewList.add(campaign_review);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("CampaignReviewDAO - selectCampaignReviewList 오류");
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return campaignReviewList;
	}

	//조회수 증가
	public void updateReadcount(int cam_re_idx) {

		PreparedStatement pstmt = null;
		
		try {
			String sql = "UPDATE campaign_review SET cam_re_readcount=cam_re_readcount+1 WHERE cam_re_idx=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, cam_re_idx);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("CampaignReviewDAO - updateReadcount 오류");
		} finally {
			close(pstmt);
		}
		
	}

	//게시물 수정
	public int updateCampaignReview(CampaignReviewDTO campaign_review) {

		int updateCount = 0;
		
		PreparedStatement pstmt = null;
		
		try {
			String sql = "UPDATE campaign_review SET cam_re_subject=?,cam_re_content=? WHERE cam_re_idx=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, campaign_review.getCam_re_subject());
			pstmt.setString(2, campaign_review.getCam_re_content());
			pstmt.setInt(3, campaign_review.getCam_re_idx());
			
			updateCount = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("CampaignReviewDAO - updateCampaignReview 오류");
		}
		
		return updateCount;
	}

	//글 권한
	public boolean isCampaignReviewWriter(int cam_re_idx, String mem_pass) {
		
		boolean isCampaignReviewWriter = false;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM campaign_review c, member m WHERE c.cam_re_id = m.mem_id AND m.mem_pass = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mem_pass);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				isCampaignReviewWriter = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("CampaignReviewDAO - isCampaignReviewWriter 오류");
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return isCampaignReviewWriter;
	}

	//캠페인후기 글 삭제
	public int deleteCampaignReview(int cam_re_idx) {

		int deleteCount = 0;
		
		PreparedStatement pstmt = null;
		
		try {
			String sql = "DELETE FROM campaign_review WHERE cam_re_idx=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, cam_re_idx);
			
			deleteCount = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("CampaignReviewDAO - deleteCampaignReview 오류");
		} finally {
			close(pstmt);
		}
		
		return deleteCount;
	}
	
}
