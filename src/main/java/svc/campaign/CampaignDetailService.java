package svc.campaign;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;

import java.sql.*;

import dao.*;
import db.*;
import vo.campaign.*;

public class CampaignDetailService {

		public CampaignDTO getCampaignDetail(int cam_idx) {
			System.out.println("CampaignDetailService");
			
			CampaignDTO campaign = null;
			
			//싱글톤 디자인 패턴으로 생성된 CampaignDAO 인스턴스 활용
			Connection con = JdbcUtil.getConnection();
			CampaignDAO dao = CampaignDAO.getInstance();
			dao.setConnection(con);
			
			//1개 게시물 상세 정보 조회 작업
			campaign = dao.selectCampaignDetail(cam_idx);
			
			close(con);
			
			return campaign;
	}
		
}
