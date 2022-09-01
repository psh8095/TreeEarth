package svc.community;

import static db.JdbcUtil.close;

import java.sql.Connection;

import dao.FreeBoardBlockDAO;
import db.JdbcUtil;
import vo.community.FreeBoardBlockDTO;

public class FreeBoardBlockDetailService {

	public FreeBoardBlockDTO getFeeBoardBlockDetail(int free_block_ref) {
		System.out.println("FreeBoardBlockDetailService");
		
		FreeBoardBlockDTO free_block = null;
		
		Connection con = JdbcUtil.getConnection();
		FreeBoardBlockDAO dao = FreeBoardBlockDAO.getInstance();
		dao.setConnection(con);
		
		//게시물 1개 조회 작업
		free_block = dao.selectFreeBoardBlockDetail(free_block_ref);
		
		close(con);
		
		return free_block;
	}

}
