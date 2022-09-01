package svc.community;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.util.ArrayList;

import dao.FreeBoardBlockDAO;
import db.JdbcUtil;
import vo.community.FreeBoardBlockDTO;

public class FreeBoardBlockListService {

	public ArrayList<FreeBoardBlockDTO> getBlockList() {
		
		ArrayList<FreeBoardBlockDTO> blockList = null;
		
		Connection con = JdbcUtil.getConnection();
		FreeBoardBlockDAO dao = FreeBoardBlockDAO.getInstance();
		dao.setConnection(con);
		
		//신고글 조회
		blockList = dao.getBlockList();
		
		close(con);
		
		return blockList;
	}

}
