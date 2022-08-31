package svc.community;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.NoticeDAO;
import db.JdbcUtil;
import vo.community.NoticeDTO;

public class NoticeModifyProService {

	public boolean isNoticeWriter(int no_idx, String mem_pass) {
		boolean isNoticeWriter = false;
		
		//싱글톤 디자인 패턴으로 생성된 NoticeDAO 인스턴스 활용
		Connection con = JdbcUtil.getConnection();
		NoticeDAO dao = NoticeDAO.getInstance();
		dao.setConnection(con);
		
		//수정 권한 판별 요청
		isNoticeWriter = dao.isNoticeWriter(no_idx, mem_pass);
		
		close(con);
		
		return isNoticeWriter;
	}
	
	// 글 수정 작업 요청
	public boolean modifyNotice(NoticeDTO notice) {

		boolean isModifySuccess = false;
		
		//싱글톤 디자인 패턴으로 생성된 BoardDAO 인스턴스 활용
		Connection con = JdbcUtil.getConnection();
		NoticeDAO dao = NoticeDAO.getInstance();
		dao.setConnection(con);
		
		//글 수정
		int updateCount = dao.updateNotice(notice);
		
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
