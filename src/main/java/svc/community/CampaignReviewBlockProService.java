package svc.community;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.rollback;

import java.sql.*;

import dao.*;
import db.*;
import vo.community.*;

public class CampaignReviewBlockProService {

	public boolean registBlock(CampaignReviewBlockDTO cam_re_block) {
		System.out.println("CampaignReviewBlockProService");
		
		boolean isBlockSuccess = false;
		
		//싱글톤 디자인 패턴으로 생성된 BoardDAO 인스턴스 활용
		Connection con = JdbcUtil.getConnection();
		CampaignReviewBlockDAO dao = CampaignReviewBlockDAO.getInstance();
		dao.setConnection(con);
		
		int insertCount = dao.insertCampaignReviewBlock(cam_re_block);
		
		if(insertCount > 0) { 
			commit(con);
			isBlockSuccess = true;
		} else { 
			rollback(con);
		}
		
		close(con);
		
		return isBlockSuccess;
	}

}
