package svc.community;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.FreeBoardBlockDAO;
import db.JdbcUtil;
import vo.community.FreeBoardBlockDTO;

public class FreeBoardBlockProService {

	public boolean registBlock(FreeBoardBlockDTO free_block) {
		System.out.println("FreeBoardBlockProService");
		
		boolean isBlockSuccess = false;
		
		//싱글톤 디자인 패턴으로 생성된 BoardDAO 인스턴스 활용
		Connection con = JdbcUtil.getConnection();
		FreeBoardBlockDAO dao = FreeBoardBlockDAO.getInstance();
		dao.setConnection(con);
		
		int insertCount = dao.insertFreeBoardBlock(free_block);
		
		if(insertCount > 0) { 
			commit(con);
			isBlockSuccess = true;
		} else { 
			rollback(con);
		}
		
		close(con);
		
		return isBlockSuccess;
	}

}
