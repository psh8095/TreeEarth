package svc.campaign;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.rollback;

import java.sql.*;

import dao.*;
import db.*;
import vo.campaign.*;

public class CampaignModifyProService {
	
		//수정 권한 판별
		public boolean isCampaignWriter(int cam_idx, String mem_pass) {
				System.out.println("CampaignModifyProService");
				
				boolean isCampaignWriter = false;
				
				//싱글톤 디자인 패턴으로 CampaignDAO 생성된 인스턴스 활용
				Connection con = JdbcUtil.getConnection();
				CampaignDAO dao = CampaignDAO.getInstance();
				dao.setConnection(con);
				
				//수정 권한 판별 요청
				isCampaignWriter = dao.isCampaignWriter(cam_idx, mem_pass);
				
				close(con);
				
				return isCampaignWriter;
			}
		
		//수정 작업 요청
		public boolean modifyCampaign(CampaignDTO campaign) {
				System.out.println("CampaignModifyProService");
				
				boolean isModifySuccess = false;
				
				Connection con = JdbcUtil.getConnection();
				CampaignDAO dao = CampaignDAO.getInstance();
				dao.setConnection(con);
				
				//글 수정
				int updateCount = dao.updateCampaign(campaign);
				
				if(updateCount > 0) {
						commit(con);
						isModifySuccess = true;
				} else {
						rollback(con);
				}
				
				close(con);
				
				return isModifySuccess;
		}
}
