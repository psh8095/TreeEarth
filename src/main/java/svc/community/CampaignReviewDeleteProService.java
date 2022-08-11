package svc.community;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.rollback;

import java.sql.*;

import dao.*;
import db.*;

public class CampaignReviewDeleteProService {

	public boolean isCampaignReviewWriter(int cam_re_idx, String mem_pass) {
		System.out.println("CampaignReviewDeleteProService");
		
		boolean isCampaignReviewWriter = false;
		
		//싱글톤 디자인 패턴으로 생성된 CampaignReviewDAO 인스턴스 활용
		Connection con = JdbcUtil.getConnection();
		CampaignReviewDAO dao = CampaignReviewDAO.getInstance();
		dao.setConnection(con);
		
		//삭제 권한 판별 요청
		isCampaignReviewWriter = dao.isCampaignReviewWriter(cam_re_idx, mem_pass);
		
		close(con);
		
		return isCampaignReviewWriter;
	}

	public boolean deleteCampaignReview(int cam_re_idx) {
		System.out.println("CampaignReviewDeleteProService");
		
		boolean isDeleteSuccess = false;
		
		//싱글톤 디자인 패턴으로 생성된 CampaignReviewDAO 인스턴스 활용
		Connection con = JdbcUtil.getConnection();
		CampaignReviewDAO dao = CampaignReviewDAO.getInstance();
		dao.setConnection(con);
		
		//삭제 요청
		int deleteCount = dao.deleteCampaignReview(cam_re_idx);
		
		if(deleteCount > 0) {
			commit(con);
			isDeleteSuccess = true;
		} else {
			rollback(con);
		}
		
		close(con);
		
		return isDeleteSuccess;
	}

}
