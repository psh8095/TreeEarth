package svc.community;

import java.sql.*;

import dao.*;
import db.*;
import vo.community.*;

public class CampaignReviewWriteProService {

	public boolean registBoard(CampaignReviewDTO cam_re) {
		
		boolean isWriteSuccess = false;
		
		//싱글톤 디자인 패턴으로 생성된 BoardDAO 인스턴스 활용
		Connection con = JdbcUtil.getConnection();
		CampaignReviewDAO dao = CampaignReviewDAO.getInstance();
		dao.setConnection(con);
		
		int insertCount = dao.insertCampaignReview(cam_re);
		
		if(insertCount > 0) { 
			JdbcUtil.commit(con);
			isWriteSuccess = true;
		} else { 
			JdbcUtil.rollback(con);
		}
		
		return isWriteSuccess;
	}

}
