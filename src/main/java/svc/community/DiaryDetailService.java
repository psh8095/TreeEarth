package svc.community;

import vo.community.*;
import static db.JdbcUtil.*;

import java.sql.*;

import dao.*;

public class DiaryDetailService {

	public DiaryDTO getDiaryDetail(int diary_idx) {
		System.out.println("4.getCampaignReviewDetail");
		//싱글톤 디자인 패턴으로 생성된 DiaryDAO 인스턴스 활용
		Connection con = getConnection();
		DiaryDAO dao = DiaryDAO.getInstance();
		dao.setConnection(con);
		
		DiaryDTO diary = null;
		
		//게시물 1개 조회 작업
		diary = dao.selectDiaryDetail(diary_idx);
		
		close(con);
		
		return diary;
	}
	
	public void increaseReadcount(int diary_idx) {
		System.out.println("5.increaseReadcount");
		//싱글톤 디자인 패턴으로 생성된 DiaryDAO 인스턴스 활용
		Connection con = getConnection();
		DiaryDAO dao = DiaryDAO.getInstance();
		dao.setConnection(con);
		
		dao.updateReadcount(diary_idx);
		
		commit(con);
		
		close(con);
		
	}


}
