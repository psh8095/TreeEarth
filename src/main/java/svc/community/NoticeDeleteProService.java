package svc.community;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.NoticeDAO;
import db.JdbcUtil;

public class NoticeDeleteProService {

	public boolean isNoticeWriter(int no_idx, String mem_pass) {
		
		boolean isNoticeWriter = false;
		
		//싱글톤 디자인 패턴으로 생성된 NoticeDAO 인스턴스 활용
		Connection con = JdbcUtil.getConnection();
		NoticeDAO dao = NoticeDAO.getInstance();
		dao.setConnection(con);
		
		//삭제 권한 판별 요청
		isNoticeWriter = dao.isNoticeWriter(no_idx, mem_pass);
		
		close(con);
		
		return isNoticeWriter;
	}

	
	public boolean deleteNotice(int no_idx) {
		
		boolean isDeleteSuccess = false;
		
		//싱글톤 디자인 패턴으로 생성된 NoticeDAO 인스턴스 활용
		Connection con = JdbcUtil.getConnection();
		NoticeDAO dao = NoticeDAO.getInstance();
		dao.setConnection(con);
		
		//삭제 요청
		int deleteCount = dao.deleteNotice(no_idx);
		
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