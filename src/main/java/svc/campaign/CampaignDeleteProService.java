package svc.campaign;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.rollback;

import java.sql.*;

import dao.*;
import db.*;

public class CampaignDeleteProService {
	
		//삭제 권한 판별 요청
		public boolean isCampaignWriter(int cam_idx, String mem_pass) {
				System.out.println("CampaignDeleteProService");
				
				boolean isCampaignWriter = false;
				
				//싱글톤 디자인 패턴으로 생성된 CampaignDAO 인스턴스 활용
				Connection con = JdbcUtil.getConnection();
				CampaignDAO dao = CampaignDAO.getInstance();
				dao.setConnection(con);
				
				//삭제 권한 판별
				isCampaignWriter = dao.isCampaignWriter(cam_idx, mem_pass);
				 
				close(con);
				
				return isCampaignWriter;
		}
		
		//삭제 요청을 수행
		public boolean deleteCampaign(int cam_idx) {
				System.out.println("CampaignDeleteProService");
				
				boolean isDeleteSuccess = false;
				
				//싱글톤 디자인 패턴으로 생성된 CampaignDAO 인스턴스 활용
				Connection con = JdbcUtil.getConnection();
				CampaignDAO dao = CampaignDAO.getInstance();
				dao.setConnection(con);
				
				//삭제 작업 수행
				int deleteCount = dao.deleteCampaign(cam_idx);
				
				if(deleteCount > 0) {
						commit(con);
						isDeleteSuccess = true;
				} else {
						rollback(con);
				}
				
				close(con);
				
				return isDeleteSuccess;  
		}

}
