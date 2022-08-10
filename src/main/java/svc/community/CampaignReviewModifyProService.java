package svc.community;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.rollback;

import java.sql.*;

import dao.*;
import db.*;
import vo.community.*;

public class CampaignReviewModifyProService {

	public boolean isCampaignReviewWriter(int cam_re_idx, String mem_pass) {
		System.out.println("CampaignReviewModifyProService");

		boolean isCampaignReviewWriter = false;
		
		//싱글톤 디자인 패턴으로 생성된 BoardDAO 인스턴스 활용
		Connection con = JdbcUtil.getConnection();
		CampaignReviewDAO dao = CampaignReviewDAO.getInstance();
		dao.setConnection(con);
		
		//수정 권한 판별 요청
		isCampaignReviewWriter = dao.isCampaignReviewWriter(cam_re_idx, mem_pass);
		
		close(con);
		
		return isCampaignReviewWriter;
	}

	//수정 작업 요청
	public boolean modifyCampaignReview(CampaignReviewDTO campaign_review) {
		System.out.println("CampaignReviewModifyProService");

		boolean isModifySuccess = false;
		
		//싱글톤 디자인 패턴으로 생성된 BoardDAO 인스턴스 활용
		Connection con = JdbcUtil.getConnection();
		CampaignReviewDAO dao = CampaignReviewDAO.getInstance();
		dao.setConnection(con);
		
		//글 수정
		int updateCount = dao.updateCampaignReview(campaign_review);
		
		if(updateCount > 0) {
			commit(con);
			isModifySuccess = true;
		} else {
			rollback(con);
		}
		
		close(con);
		
		return isModifySuccess;
	}

}
