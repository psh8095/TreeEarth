package svc.community;

import static db.JdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

import dao.NoticeDAO;
import db.JdbcUtil;
import vo.community.NoticeDTO;

public class NoticeListService {

	public int getNoticeListCount() {
		int listCount = 0;
		
		//싱글톤 디자인 패턴으로 생성된 NoticeDAO 인스턴스 활용
		Connection con = JdbcUtil.getConnection();
		NoticeDAO dao = NoticeDAO.getInstance();
		dao.setConnection(con);
		
		//전체 게시물 목록 조회
		listCount = dao.selectListCount();
		
		close(con);
		
		return listCount;
	}


	public static ArrayList<NoticeDTO> getNoticeList(int pageNum, int listLimit) {
		ArrayList<NoticeDTO> noticeList = null;
		
		//싱글톤 디자인 패턴으로 생성된 NoticeDAO 인스턴스 활용
		Connection con = JdbcUtil.getConnection();
		NoticeDAO dao = NoticeDAO.getInstance();
		dao.setConnection(con);
		
		noticeList = dao.selectNoticeList(pageNum, listLimit);
		
		close(con);

		return noticeList;
	}

}