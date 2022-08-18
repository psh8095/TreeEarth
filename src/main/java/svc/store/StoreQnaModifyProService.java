package svc.store;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.StoreDAO;
import vo.store.StoreQnaDTO;

public class StoreQnaModifyProService {
	
	public boolean isStoreQnaWrite(int sto_qna_idx, String mem_pass) {
		System.out.println("StoreQnaModifyProService");
		
		boolean isStoreQnaWrite = false;
		
		Connection con = getConnection();
		StoreDAO dao = StoreDAO.getInstance();
		dao.setConnection(con);
		
		// 수정 권한 판별 요청
		isStoreQnaWrite = dao.isStoreQnaWrite(sto_qna_idx, mem_pass);
		
		close(con);
		
		return isStoreQnaWrite;
	}
	
	// 글 수정 작업 요청
	public boolean modifyStoreQna(StoreQnaDTO store_qna) {
		
		boolean isQnaModifySuccess = false;
		
		Connection con = getConnection();
		StoreDAO dao = StoreDAO.getInstance();
		dao.setConnection(con);
		
		// 글 수정 작업
		int updateQnaCount = dao.updateStoreQna(store_qna);
		
		if(updateQnaCount >0) {
			commit(con);
			isQnaModifySuccess = true;
		} else {
			rollback(con);
		}
		
		close(con);
		
		return isQnaModifySuccess;
	}

}





















