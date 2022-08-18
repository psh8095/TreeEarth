package svc.campaign;

import vo.campaign.CampaignApplyDTO;
import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.CampaignDAO;

public class CampaignApplyProService {

	public void insertApply(CampaignApplyDTO apply) {
		System.out.println("CampaignApplyProService");
		
		Connection con = getConnection();
		CampaignDAO dao = CampaignDAO.getInstance();
		dao.setConnection(con);
		
		int insertCount = dao.insertCampaignApply(apply);
		
		if(insertCount > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
	}

}
