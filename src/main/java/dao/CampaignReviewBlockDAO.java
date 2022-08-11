package dao;

import static db.JdbcUtil.close;

import java.sql.*;

import vo.community.*;

public class CampaignReviewBlockDAO {

	//싱글톤 디자인 패턴
	private static CampaignReviewBlockDAO instance = new CampaignReviewBlockDAO();
	
	private CampaignReviewBlockDAO() {}
	
	public static CampaignReviewBlockDAO getInstance() {
		return instance;
	}	
	
	private Connection con;
	
	public void setConnection(Connection con) {
		this.con = con;
	}

	public int insertCampaignReviewBlock(CampaignReviewBlockDTO cam_re_block) {
		System.out.println("CampaignReviewBlockDAO");
		
		int insertCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int num = 1;
		
		try {
			//새 신고글번호 저장
			String sql = "SELECT MAX(cam_re_block_idx) FROM cam_re_block";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				num = rs.getInt(1) + 1;
			}
			
			close(pstmt);
			
			//신고글 DB에 저장
			sql = "INSERT INTO cam_re_block VALUES (?,?,?,?,now())";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setInt(2, cam_re_block.getCam_re_block_ref());
			pstmt.setString(3, cam_re_block.getCam_re_block_id());
			pstmt.setString(4, cam_re_block.getCam_re_block_reason());
			
			insertCount = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("CampaignReviewBlockDAO - insertCampaignReviewBlock 오류");
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return insertCount;
	}
	
}
