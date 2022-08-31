package svc.community;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import dao.NoticeDAO;
import vo.community.NoticeDTO;

public class NoticeDetailService {
	
	// 게시물 상세 정보 조회 작업
	public NoticeDTO getNoticeDetail(int no_idx) {
		NoticeDTO notice = null;
		
		Connection con = getConnection();
		NoticeDAO dao = NoticeDAO.getInstance();
		dao.setConnection(con);
		
		// NoticeDAO 객체의 selectNoticeDetail() 메서드를 호출하여 1개 게시물의 상세 정보 조회 작업 수행
		notice = dao.selectNoticeDetail(no_idx);
		
		close(con);
		
		return notice;
	}

}



