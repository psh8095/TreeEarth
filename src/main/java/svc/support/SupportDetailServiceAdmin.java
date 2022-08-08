package svc.support;

import vo.support.SupportDTO;
import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.SupportDAO;


public class SupportDetailServiceAdmin {

	public void increaseReadCount(int sup_idx) {
		
	}

	public SupportDTO getBoard(int sup_idx) {
		SupportDTO dto = null;
		
		Connection con = getConnection();
		SupportDAO dao = SupportDAO.getInstance();
		dao.setConnection(con);
		

		dto = dao.selectBoard(sup_idx);
		
		close(con);
		return dto;
	}

}
