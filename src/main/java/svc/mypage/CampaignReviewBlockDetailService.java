package svc.mypage;

import static db.JdbcUtil.close;

import java.sql.*;

import dao.*;
import db.*;
import vo.community.*;

public class CampaignReviewBlockDetailService {

	public CampaignReviewBlockDTO getCampaignReviewBlockDetail(int cam_re_block_ref) {
		System.out.println("CampaignReviewBlockDetailService");
		
		CampaignReviewBlockDTO cam_re_block = null;
		
		Connection con = JdbcUtil.getConnection();
		CampaignReviewBlockDAO dao = CampaignReviewBlockDAO.getInstance();
		dao.setConnection(con);
		
		//게시물 1개 조회 작업
		cam_re_block = dao.selectCampaignReviewBlockDetail(cam_re_block_ref);
		
		close(con);
		
		return cam_re_block;
	}

}
