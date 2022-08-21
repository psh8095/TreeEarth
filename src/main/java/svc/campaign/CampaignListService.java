package svc.campaign;

import static db.JdbcUtil.close;

import java.sql.*;
import java.util.*;

import dao.*;
import db.*;
import vo.campaign.*;

public class CampaignListService {

	public int getCampaignListService() {
		
		int listCount = 0;
		
		//싱글톤 디자인 패턴으로 생성된 CampaignDAO 인스턴스 활용
		Connection con = JdbcUtil.getConnection();
		CampaignDAO dao = CampaignDAO.getInstance();
		dao.setConnection(con);
		
		//전체 게시물 수 조회
		listCount = dao.selectListCount();
//		System.out.println("listCount : " + listCount);
		
		close(con);
		
		return listCount;
	}
	
	public static ArrayList<CampaignDTO> getCampaignList() {
		
		ArrayList<CampaignDTO> campaignList = null;
		
		//싱글톤 디자인 패턴으로 생성된 CampaignDAO 인스턴스 활용
		Connection con = JdbcUtil.getConnection();
		CampaignDAO dao = CampaignDAO.getInstance();
		dao.setConnection(con);
		
		//게시물 목록 조회
		campaignList = dao.selectCampaignList();
//		System.out.println(campaignList);
		
		close(con);
		
		return campaignList;
	}
}
