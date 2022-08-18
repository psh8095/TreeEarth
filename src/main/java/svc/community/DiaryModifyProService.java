package svc.community;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.*;

import dao.*;
import vo.community.*;

public class DiaryModifyProService {
	public boolean isDiaryWriter(int diary_idx, String mem_pass) {
		System.out.println("4.DiaryModifyProService");

		boolean isDiaryWriter = false;
		
		//싱글톤 디자인 패턴으로 생성된 BoardDAO 인스턴스 활용
		Connection con = getConnection();
		DiaryDAO dao = DiaryDAO.getInstance();
		dao.setConnection(con);
		
		//수정 권한 판별 요청
		isDiaryWriter = dao.isDiaryWriter(diary_idx, mem_pass);
		
		close(con);
		
		return isDiaryWriter;
	}

	//수정 작업 요청
	public boolean modifyDiary(DiaryDTO diary) {
		System.out.println("4.modifyCampaignReview");

		boolean isModifySuccess = false;
		
		//싱글톤 디자인 패턴으로 생성된 DiaryDAO 인스턴스 활용
		Connection con = getConnection();
		DiaryDAO dao = DiaryDAO.getInstance();
		dao.setConnection(con);
		
		//글 수정
		int updateCount = dao.updateDiary(diary);
		
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
