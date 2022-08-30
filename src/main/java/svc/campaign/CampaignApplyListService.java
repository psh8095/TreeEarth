package svc.campaign;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.List;

import dao.CampaignDAO;
import vo.campaign.ApplyListDTO;
import vo.campaign.CampaignApplyDTO;

public class CampaignApplyListService {

	public List<ApplyListDTO> getApplyList(String sId) {
		System.out.println("CampaignApplyListService");
		List<ApplyListDTO> applyList = null;
		
		Connection con = getConnection();
		CampaignDAO dao = CampaignDAO.getInstance();
		dao.setConnection(con);
		
		if(sId.equals("admin")) {
			applyList = dao.selectCampaignApplyList();
		} else {
			applyList = dao.selectCampaignApplyList(sId);
		}
		
		close(con);
		
		return applyList;
	}

}
