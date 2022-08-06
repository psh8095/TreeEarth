package dao;

import static db.JdbcUtil.close;

import java.sql.*;

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
	public int insertCampaignReview(CampaignReviewDTO cam_re) {
		
		int insertCount = 0; 
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int num = 1;
		
		try {
			//새 글 번호 저장 
			String sql = "SELECT MAX(cam_re_idx) FROM cam_re";
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
			pstmt.setString(2, cam_re.getCam_re_id());
			pstmt.setString(3, cam_re.getCam_re_subject());
			pstmt.setString(4, cam_re.getCam_re_content());
			pstmt.setInt(5, 0); //readcount
			pstmt.setString(6, cam_re.getCam_re_file());
			pstmt.setString(7, cam_re.getCam_re_real_file());
			pstmt.setString(8, cam_re.getCam_re_thum_file());
			pstmt.setString(9, cam_re.getCam_re_thum_real_file());
			
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
	
}
