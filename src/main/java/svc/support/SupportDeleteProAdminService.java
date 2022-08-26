package svc.support;

import static db.JdbcUtil.*;

import java.sql.*;

import dao.*;

public class SupportDeleteProAdminService {

	public boolean isBoardWriter(int sup_idx, String mem_pass) {
		boolean isBoardWriter = false;

		Connection con = getConnection();
		SupportDAO dao = SupportDAO.getInstance();
		dao.setConnection(con);

		isBoardWriter = dao.isBoardWriter(sup_idx, mem_pass);
//	modify랑 똑같은 isboardwriter 메서드 사용

		close(con);

		return isBoardWriter;

	}

	public boolean deleteSupport(int sup_idx) {
		boolean isDeleteSuccess = false;
		Connection con = getConnection();
		SupportDAO dao = SupportDAO.getInstance();
		dao.setConnection(con);

		int deleteCount = dao.deleteBoard(sup_idx);

		if (deleteCount > 0) {
			commit(con);
			isDeleteSuccess = true;
		} else {
			rollback(con);
		}
		close(con);
		return isDeleteSuccess;

	}


}