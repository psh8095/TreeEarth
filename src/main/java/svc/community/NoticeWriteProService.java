package svc.community;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.NoticeDAO;
import db.JdbcUtil;
import vo.community.NoticeDTO;

public class NoticeWriteProService {

	public boolean registBoard(NoticeDTO notice) {
		boolean isWriteSuccess = false;
		
		//싱글톤 디자인 패턴으로 생성된 BoardDAO 인스턴스 활용
		Connection con = JdbcUtil.getConnection();
		NoticeDAO dao = NoticeDAO.getInstance();
		dao.setConnection(con);
		
		int insertCount = dao.insertNotice(notice);
		
		if(insertCount > 0) { 
			commit(con);
			isWriteSuccess = true;
		} else { 
			rollback(con);
		}
		
		close(con);
		
		return isWriteSuccess;
	}

}
