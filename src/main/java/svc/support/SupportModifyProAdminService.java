package svc.support;

import java.sql.Connection;

import dao.SupportDAO;
import vo.support.SupportDTO;

import static db.JdbcUtil.*;

public class SupportModifyProAdminService {
	
	public boolean isBoardWriter(int sup_idx, String mem_pass) {
		System.out.println("SupportModifyProAdminService");
	
		boolean isBoardWriter = false;
	
	Connection con = getConnection();
	SupportDAO dao = SupportDAO.getInstance();
	dao.setConnection(con);
	
	isBoardWriter = dao.isBoardWriter(sup_idx, mem_pass);
	
	close(con);
	
	return isBoardWriter;
	
	}
	
	public boolean modifySupportBoard(SupportDTO dto) {
		boolean isModifySuccess = false;
		
	Connection con = getConnection();
	SupportDAO dao = SupportDAO.getInstance();
	dao.setConnection(con);
	
	
	
	int updateCount = dao.supportUpdateBoard(dto);
	if(updateCount > 0) {
		commit(con);
		isModifySuccess = true;
	}else {
		rollback(con);
	}
	
	return isModifySuccess;
	}
	
}
