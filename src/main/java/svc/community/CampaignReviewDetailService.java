package svc.community;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;

import java.sql.*;

import dao.*;
import db.*;
import vo.community.*;

public class CampaignReviewDetailService {

	//상세조회
	public CampaignReviewDTO getCampaignReviewDetail(int cam_re_idx) {
		System.out.println("CampaignReviewDetailService");

		CampaignReviewDTO campaign_review = null;
		
		//싱글톤 디자인 패턴으로 생성된 CampaignReviewDAO 인스턴스 활용
		Connection con = JdbcUtil.getConnection();
		CampaignReviewDAO dao = CampaignReviewDAO.getInstance();
		dao.setConnection(con);
		
		//게시물 1개 조회 작업
		campaign_review = dao.selectCampaignReviewDetail(cam_re_idx);
		
		close(con);
		
		return campaign_review;
	}

	//조회수 증가
	public void increaseReadcount(int cam_re_idx) {

		//싱글톤 디자인 패턴으로 생성된 CampaignReviewDAO 인스턴스 활용
		Connection con = JdbcUtil.getConnection();
		CampaignReviewDAO dao = CampaignReviewDAO.getInstance();
		dao.setConnection(con);
		
		//게시물 조회수 증가
		dao.updateReadcount(cam_re_idx);
		
		commit(con);
		
		close(con);
		
	}

}
