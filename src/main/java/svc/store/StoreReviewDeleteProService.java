package svc.store;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.StoreDAO;

public class StoreReviewDeleteProService {

	public boolean isStoreReviewWrite(int sto_re_idx, String mem_pass) {
		System.out.println("StoreReviewDeleteProService");
		
		boolean isStoreReviewWrite = false;
		
		Connection con = getConnection();
		StoreDAO dao = StoreDAO.getInstance();
		dao.setConnection(con);
		
		// 삭제 권한 판별 요청
		isStoreReviewWrite = dao.isStoreReviewWrite(sto_re_idx, mem_pass);
		
		close(con);
		
		return isStoreReviewWrite;
	}

	public boolean deleteStoreReview(int sto_re_idx) {
		System.out.println("deleteStoreReview 메서드");
		
		boolean isReviewDeleteSuccess = false;
		
		Connection con = getConnection();
		StoreDAO dao = StoreDAO.getInstance();
		dao.setConnection(con);
		
		// 삭제 요청
		int deleteCount = dao.deleteStoreReview(sto_re_idx);
		
		if(deleteCount > 0) {
			commit(con);
			isReviewDeleteSuccess = true;
		} else {
			rollback(con);
		}
		
		close(con);
		
		return isReviewDeleteSuccess;
	}

}
























