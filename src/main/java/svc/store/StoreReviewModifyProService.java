package svc.store;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.StoreDAO;
import vo.store.StoreReviewDTO;

public class StoreReviewModifyProService {

	public boolean isStoreReviewWrite(int sto_re_idx, String mem_pass) {
		System.out.println("StoreReviewModifyProService");
		
		boolean isStoreReviewWrite = false;
		
		Connection con = getConnection();
		StoreDAO dao = StoreDAO.getInstance();
		dao.setConnection(con);
		
		// 수정 권한 판별 요청
		isStoreReviewWrite = dao.isStoreReviewWrite(sto_re_idx, mem_pass);
		
		close(con);
		
		return isStoreReviewWrite;
	}
	
	// 글 수정 작업 요청
	public boolean modifyStoreReview(StoreReviewDTO store_review) {
		
		boolean isReviewModifySuccess = false;
		
		Connection con = getConnection();
		StoreDAO dao = StoreDAO.getInstance();
		dao.setConnection(con);
		
		// 글 수정 작업
		int updateCount = dao.updateStoreReview(store_review);
		
		if(updateCount > 0) {
			commit(con);
			isReviewModifySuccess = true;
		} else {
			rollback(con);
		}
		
		close(con);
		
		return isReviewModifySuccess;
	}

}




















