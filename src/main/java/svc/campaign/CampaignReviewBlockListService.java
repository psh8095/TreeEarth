package svc.campaign;

import static db.JdbcUtil.close;

import java.sql.*;
import java.util.*;

import dao.*;
import db.*;
import vo.community.*;

public class CampaignReviewBlockListService {

	public ArrayList<CampaignReviewBlockDTO> getBlockList() {
		
		ArrayList<CampaignReviewBlockDTO> blockList = null;
		
		Connection con = JdbcUtil.getConnection();
		CampaignReviewBlockDAO dao = CampaignReviewBlockDAO.getInstance();
		dao.setConnection(con);
		
		//신고글 조회
		blockList = dao.getBlockList();
		
		close(con);
		
		return blockList;
	}

}
