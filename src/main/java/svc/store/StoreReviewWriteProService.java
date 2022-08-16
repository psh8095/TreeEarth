package svc.store;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.StoreDAO;
import vo.store.StoreReviewDTO;

public class StoreReviewWriteProService {

	public boolean getStoreReview(StoreReviewDTO storeReview) {
		
		boolean isWriteReviewSuccess = false;
		
		Connection con = getConnection();
		StoreDAO dao = StoreDAO.getInstance();
		dao.setConnection(con);
		
		int insertReviewCount = dao.insertStoreReview(storeReview);
		
		if(insertReviewCount > 0) { // 후기 작성 성공할 경우
			commit(con);
			isWriteReviewSuccess = true;
		} else { // 실패할 경우
			rollback(con);
		}
		 
		close(con);
		
		return isWriteReviewSuccess;
	}

}
