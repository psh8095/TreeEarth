package svc.community;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.*;

import dao.*;
import db.*;

public class DiaryDeleteProService {

	public boolean isDiaryWriter(int diary_idx, String mem_pass) {
		System.out.println("4.isDiaryWriter");
		
		boolean isDiaryWriter = false;
		
		//싱글톤 디자인 패턴으로 생성된 DiaryDAO 인스턴스 활용
				Connection con = getConnection();
				DiaryDAO dao = DiaryDAO.getInstance();
				dao.setConnection(con);
				
		
		//삭제 권한 판별 요청
		isDiaryWriter = dao.isDiaryWriter(diary_idx, mem_pass);
		
		close(con);
		
		return isDiaryWriter;
	}

	public boolean deleteDiary(int diary_idx) {
		System.out.println("5.deleteDiary");
		boolean isDeleteSuccess = false;
		
		//싱글톤 디자인 패턴으로 생성된 CampaignReviewDAO 인스턴스 활용
		Connection con = getConnection();
		DiaryDAO dao = DiaryDAO.getInstance();
		dao.setConnection(con);
		
		//삭제 요청
		int deleteCount = dao.deleteDiary(diary_idx);
		
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
