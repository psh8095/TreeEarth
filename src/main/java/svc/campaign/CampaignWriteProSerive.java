package svc.campaign;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.rollback;

import java.sql.*;

import dao.*;
import db.*;
import vo.campaign.*;

public class CampaignWriteProSerive {

	public boolean registBoard(CampaignDTO campaign) {
		
		boolean isWriteSuccess = false;
		
		//싱글톤 디자인 패턴으로 생성된 CampaignDAO 인스턴스 활용
		Connection con = JdbcUtil.getConnection();
		CampaignDAO dao = CampaignDAO.getInstance();
		dao.setConnection(con);
		
		//글 작성
		int insertCount = dao.insertCampaign(campaign);
		
		if(insertCount > 0) {
				commit(con);
				isWriteSuccess = true;
		} else {
				rollback(con);
		}
		
		close(con);
		
		return isWriteSuccess;
	}
}
