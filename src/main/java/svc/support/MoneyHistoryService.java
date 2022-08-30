package svc.support;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import dao.CampaignReviewBlockDAO;
import dao.SupportHistoryDAO;
import db.JdbcUtil;
import vo.support.SupportHistoryDTO;

import static db.JdbcUtil.*;

public class MoneyHistoryService {

	public void regiestSupport(SupportHistoryDTO supporthistory) {
		
		Connection con = JdbcUtil.getConnection();
		SupportHistoryDAO dao = SupportHistoryDAO.getInstance();
		dao.setConnection(con);
		
		int insertCount = dao.insertHistory(supporthistory);
		
		if(insertCount > 0) { 
			commit(con);
		} else { 
			rollback(con);
		}
		
		close(con);
	}

	public ArrayList<SupportHistoryDTO> getSupportHistory(String mem_id) {
		System.out.println("getSupportHistory");
		
		ArrayList<SupportHistoryDTO> supList = null;
		
		Connection con = JdbcUtil.getConnection();
		SupportHistoryDAO dao = SupportHistoryDAO.getInstance();
		dao.setConnection(con);
		
		//후원내역 조회
		supList = dao.getsupportList(mem_id);
		System.out.println("service" + supList);
		
		close(con);
		
		return supList;
	}

}
