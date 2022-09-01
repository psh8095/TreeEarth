package svc.community;

import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import dao.DiaryDAO;

import static db.JdbcUtil.*;

public class DiaryHeartService {

	public int updateLike(int diaryno, String mid) {
		System.out.println("updateLike");

		int updateLike = 0;
		
		Connection con = getConnection();
		DiaryDAO dao = DiaryDAO.getInstance();
		dao.setConnection(con);
		
		updateLike = dao.updateLike(diaryno, mid);
		System.out.println(updateLike);
		
		close(con);
		
		return updateLike;
	}

	public int updateDiary(int diaryno, int updateLike, int likecnt) {
		System.out.println("updateDiary");
		 int updateCount = 0;
		  
		Connection con = getConnection();
		DiaryDAO dao = DiaryDAO.getInstance();
		dao.setConnection(con);
		
		updateCount = dao.updateDiary(diaryno, updateLike, likecnt);
		System.out.println(updateCount);
		
		return updateCount;
		
	}
	
	
}
