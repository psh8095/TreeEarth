package svc.store;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.StoreDAO;
import vo.store.StoreReviewDTO;

public class StoreReviewDetailService {

	public StoreReviewDTO getStoreReviewDetail(int sto_re_idx) {
		System.out.println("StoreReviewDetailService");
		
		StoreReviewDTO store_review = null;
		
		Connection con = getConnection();
		StoreDAO dao = StoreDAO.getInstance();
		dao.setConnection(con);
		
		// 글 1개 조회 작업
		store_review = dao.selectStoreReviewDetail(sto_re_idx);
		
		close(con);
		
		return store_review;
	}

}
