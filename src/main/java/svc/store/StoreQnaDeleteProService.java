package svc.store;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.StoreDAO;

public class StoreQnaDeleteProService {

	public boolean inStoreQnaWrite(int sto_qna_idx, String mem_pass) {
		System.out.println("StoreQnaDeleteProService");
		
		boolean isStoreQnaWrite = false;
		
		Connection con = getConnection();
		StoreDAO dao = StoreDAO.getInstance();
		dao.setConnection(con);
		
		// 삭제 권한 판별 요청
		isStoreQnaWrite = dao.isStoreQnaWrite(sto_qna_idx, mem_pass);
		
		close(con);
		
		return isStoreQnaWrite;
	}

	public boolean deleteStoreQna(int sto_qna_idx) {
		
		boolean isQnaDeleteSuccess = false;
		
		Connection con = getConnection();
		StoreDAO dao = StoreDAO.getInstance();
		dao.setConnection(con);
		
		// 삭제 요청
		int storeQnaDeleteCount = dao.deleteStoreQna(sto_qna_idx);
		
		if(storeQnaDeleteCount > 0) {
			commit(con);
			isQnaDeleteSuccess = true;
		} else {
			rollback(con);
		}
		
		close(con);
		
		return isQnaDeleteSuccess;
	}

}














